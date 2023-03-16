package codegym.vn.controller;
import codegym.vn.model.HomDienTu;
import codegym.vn.repository.HomDienTuRepository;
import codegym.vn.repository.IHomDienTuRepository;
import com.sun.org.apache.xpath.internal.operations.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/homDienTu")
public class HomDienTuController {
    private IHomDienTuRepository iHomDienTuRepository;
    @Autowired
    public HomDienTuController(IHomDienTuRepository iHomDienTuRepository){
        this.iHomDienTuRepository=iHomDienTuRepository;
    }
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String showForm(Model model){
        HomDienTu homDienTu=new HomDienTu();
        String[] languages=new String[]{"English","Vietnamese","Japanese","Chinese"};
        String[] pageSize=new String[]{"5","10","15","25","50","100"};
        model.addAttribute("homDienTu",homDienTu);
        model.addAttribute("languages",languages);
        model.addAttribute("pageSize",pageSize);
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "homDienTu") HomDienTu homDienTu){
        iHomDienTuRepository.create(homDienTu);
        return"redirect:/homDienTu/list";
    }
    @GetMapping(value = "/list")
    public String display(Model model){
        model.addAttribute("homDienTu",iHomDienTuRepository.findAll());
        return "list";
    }
    @GetMapping("/check/{id}")
    public String check(Model model, @PathVariable("id") String id ){
        String[] languages=new String[]{"English","Vietnamese","Japanese","Chinese"};
        String[] pageSize=new String[]{"5","10","15","25","50","100"};
        model.addAttribute("languages",languages);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("homDienTu",iHomDienTuRepository.findById(id));
        return "update";
    }

}
