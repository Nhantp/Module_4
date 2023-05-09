package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import product.model.Product;
import product.service.ICategoryService;
import product.service.IProductService;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = {"","/"})
    public String display(@RequestParam("page")Optional<Integer> page,
                          @RequestParam("size") Optional<Integer>size,Model model) {
            int currentPage=page.orElse(1);
            int pageSize=size.orElse(2);
            Slice<Product> products=iProductService.findAllWithSlice(PageRequest.of(currentPage-1,pageSize));
            model.addAttribute("products",products.getContent());
            model.addAttribute("page",products);
        return "product/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("products", new Product());
        model.addAttribute("categories",iCategoryService.findAll());
        return "product/create";
    }

    @PostMapping("create")
    public String doCreate(@Valid @ModelAttribute("products") Product product,
                           BindingResult bindingResult) {
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("delete")
    public String delete(@RequestParam(name = "productId") Integer productId) {
        Product product = iProductService.findProductById(productId);
        iProductService.delete(product);
        return "redirect:/product/list";
    }
    @GetMapping("update")
    public String showUpdate(@RequestParam(name = "productId") Integer productId, Model model){
        Product product=iProductService.findProductById(productId);
        model.addAttribute("products",product);
        model.addAttribute("categories",iCategoryService.findAll());
        return "product/update";
    }
    @PostMapping("update")
    public String doUpdate(@ModelAttribute("products") Product product){
        iProductService.update(product);
        return "redirect:/product/list";
    }
    @GetMapping("search")
    public String search(@RequestParam(name="searchAll") String searchAll,
                         @RequestParam("page")Optional<Integer> page,
                         @RequestParam("size") Optional<Integer>size,Model model){
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(2);
        model.addAttribute("searchAll",searchAll);
        Slice<Product> products=iProductService.searchAll(searchAll,searchAll,searchAll,PageRequest.of(currentPage-1,pageSize));
        model.addAttribute("products",products.getContent());
        model.addAttribute("page",products);
        return "/product/list";
    }
}

