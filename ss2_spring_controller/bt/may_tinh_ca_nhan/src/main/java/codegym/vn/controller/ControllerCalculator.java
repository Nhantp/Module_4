package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerCalculator {
    @GetMapping("mayTinh")
    public String mayTinh(){
        return "list";
    }
    @PostMapping("calculate")
    public String calculate(Model model, @RequestParam("text1") int text1, @RequestParam("text2") int text2,
                            @RequestParam("operation")String operation){
        int result=0;
        switch (operation){
            case "Add":
                result=text1+text2;
                break;
            case "Sub":
                result=text1-text2;
                break;
            case "Multi":
                result=text1*text2;
                break;
            case "Div":
                result=text1/text2;
                break;
        }
        model.addAttribute("result",result);
        return "list";
    }
}
