package codegym.vn.controller;

import codegym.vn.repository.DictionaryRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    DictionaryRepository dictionaryRepository=new DictionaryRepository();
    @GetMapping("/tuDien")
    public String display(){
      return "list" ;
    }
    @GetMapping("/dictionary")
    public String dictionary(Model model, @RequestParam String eng){
        model.addAttribute("result",dictionaryRepository.dictionary(eng));
        return "list";
    }
}
