package codegym.vn.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
//    @GetMapping("/tienTe")
//    public ModelAndView Display(){
//        ModelAndView modelAndView=new ModelAndView("list");
//        modelAndView.addObject("usd",0);
//        modelAndView.addObject("rate",0);
//        modelAndView.addObject("result",0);
//        return modelAndView;
//    }
    @GetMapping("/tienTe")
    public String display(){
        return "list";
    }
    @GetMapping("/convert")
    public String convert(@RequestParam double usd,Model model ){
       double change = usd*23000;
       model.addAttribute("result",change);
        return  "list";
    }
//    @GetMapping("/convert")
//    public ModelAndView Convert(@RequestParam double usd){
//        ModelAndView modelAndView=new ModelAndView("list");
//        modelAndView.addObject("usd",usd);
//        modelAndView.addObject("result",usd*23000);
//        return modelAndView;
//    }

}
