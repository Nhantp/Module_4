package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/mayTinh")
    public String mayTinh(){
        return "list";
    }
    @PostMapping("/calculate")
    public String calculate(){

    }
}
