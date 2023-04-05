package bucanh.controller;

import bucanh.entity.ImageOfTheDay;
import bucanh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    private ImageController(ImageService imageService){
        this.imageService=imageService;
    }
    @GetMapping("/list")
    public String display(Model model){
        model.addAttribute("image",imageService.findAll());
        return "img/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        ImageOfTheDay image=new ImageOfTheDay();
        model.addAttribute("image",image);
        return "/img/create";
    }
}
