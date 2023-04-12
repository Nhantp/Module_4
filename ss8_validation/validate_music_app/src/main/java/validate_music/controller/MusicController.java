package validate_music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import validate_music.validate.MusicValidate;
import validate_music.model.Music;
import validate_music.service.IMusicService;

import javax.validation.Valid;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService iMusicService;
    @Autowired
    MusicValidate musicValidate;

    @GetMapping("list")
    public String display(Model model){
        model.addAttribute("music",iMusicService.finAll());
        return "music/list";
    }
    @GetMapping("create")
    String showCreate(Model model){
        model.addAttribute("music",new Music());
        return "music/create";
    }
    @PostMapping("create")
    public String doCreate(@Valid @ModelAttribute(name = "music") Music music,
                           BindingResult bindingResult){
        musicValidate.validate(music,bindingResult);
        if(bindingResult.hasErrors()) {
            return "music/create";
        }
        iMusicService.insert(music);
        return "redirect:/music/list";
    }
}
