package codegym.vn.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/giaVi")
    public String display(){
        return "list";
    }
    @PostMapping("/condiment")
    public String condiment(Model model,@RequestParam ("condiment") String[] condiment){
        model.addAttribute("result",condiment);
        return "list";
    }

}
