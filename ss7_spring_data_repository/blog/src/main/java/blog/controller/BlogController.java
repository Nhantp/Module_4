package blog.controller;

import blog.entity.Blog;
import blog.entity.Category;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import blog.service.IBlogService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    private BlogController(IBlogService iBlogService){
        this.iBlogService=iBlogService;
    }
//    @GetMapping("/list")
//    public String display(Model model){
//        model.addAttribute("blog",iBlogService.findAll());
//        return "/blog/list";
//    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",iCategoryService.findAll());
        return "/blog/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog,@RequestParam("img") MultipartFile image){
        if (image.isEmpty()){
            blog.setImage("");
        }
        Path path = Paths.get("upload/");
        try{
            InputStream inputStream = image.getInputStream();
            Files.copy(inputStream, path.resolve(image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            blog.setImage(image.getOriginalFilename().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate today = LocalDate.now();

        blog.setTime(String.valueOf(today));
        iBlogService.addNew(blog);
        return "redirect:/blog/";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam(name = "id") Integer id,Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("category",iCategoryService.findAll());
        return "/blog/update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute(name = "blog") Blog blog){
        LocalDate today = LocalDate.now();
        blog.setTime(String.valueOf(today));
        iBlogService.update(blog);

        return "redirect:/blog/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id){
        Blog blog=iBlogService.findById(id);
        iBlogService.delete(blog);
        return "redirect:/blog/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam(name = "searchAll") String searchAll ,
                         @RequestParam(name = "page") Optional<Integer>page,
                         @RequestParam(name = "size") Optional<Integer> size,Model model){
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(2);
        model.addAttribute("searchAll",searchAll);
//        Sort sortBy = Sort.by("time").descending().and(Sort.by("title").ascending());
        Slice<Blog>blog=iBlogService.findAllByCategory_CategoryNameContainingOrTitleContainingOrContentContainingOrTimeContaining(searchAll,searchAll,searchAll,searchAll, PageRequest.of(currentPage-1,pageSize));
        model.addAttribute("blog",blog.getContent());
        model.addAttribute("page",blog);
        return "/blog/list";
    }
    @GetMapping(value = {"","/"})
    public String paging(@RequestParam(name = "page") Optional<Integer>page,
                         @RequestParam(name = "size") Optional<Integer> size,
                         @RequestParam("sort") Optional<String> sort ,Model model){
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(2);
        Sort sortBy = Sort.by("time").descending().and(Sort.by("title").ascending());
        Slice<Blog>blog=iBlogService.findAllWithSlice(PageRequest.of(currentPage-1,pageSize));
        model.addAttribute("blog",blog.getContent());
        model.addAttribute("page",blog);
        return "/blog/list";
    }
//    @GetMapping("sort")
//    public String sort(@RequestParam(name = "page") Optional<Integer>page,
//                       @RequestParam(name = "size") Optional<Integer> size,Model model){
//        int currentPage=page.orElse(1);
//        int pageSize=size.orElse(4);
//        Slice<Blog>blog=iBlogService.findAllWithSlice(PageRequest.of(currentPage-1,pageSize));
//        Slice<Blog>blogs=iBlogService.SortByTime(PageRequest.of(currentPage-1,pageSize));
//        model.addAttribute("blog",blog.getContent());
//        model.addAttribute("page",blog);
//        model.addAttribute("blog",blogs);
//        return "/blog/list";
//    }

//    @GetMapping("pagingPage")
//    public  String pagingPage(@RequestParam("page") Optional<Integer>page,
//                          @RequestParam("size") Optional<Integer>size,
//                          Model model){
//        int currentPage=page.orElse(1);
//        int pageSize=size.orElse(2);
//        Pageable pageable=PageRequest.of(currentPage-1,pageSize);
//        Page<Blog>blogs=iBlogService.findAllWithPage(pageable);
//        model.addAttribute("blog",blogs);
//        int totalPage=blogs.getTotalPages();
//        if(totalPage>1){
//            List<Integer> pageNumber = IntStream.rangeClosed(1,totalPage)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumber",pageNumber);
//        }
//        return "blog/pagingPage";
//    }
}
