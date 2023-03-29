package nghenhac.controller;

import nghenhac.entity.Music;
import nghenhac.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/music")
public class MusicController {
    private IMusicService iMusicService;
    @Autowired
    public MusicController(IMusicService iMusicService){
        this.iMusicService=iMusicService;
    }
    @GetMapping("list")
    public String display(Model model){
        model.addAttribute("music",iMusicService.findAll());
        return "/music/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music",new Music());
        return "music/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "music")Music music){
        iMusicService.addNew(music);
        return "redirect:/music/list";
    }
    @GetMapping("update/{id}")
    public String showUpdate(Model model, @PathVariable int id){
        model.addAttribute("music",iMusicService.findById(id));
        return "music/update";
    }
    @PostMapping("/update/{id}")
    public String doUpdate(Model model,@ModelAttribute(name = "music") Music music){
        iMusicService.update(music);
        return "redirect:/music/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable int id){
        model.addAttribute("music",iMusicService.findById(id));
        Music music=iMusicService.findById(id);
        iMusicService.delete(music);
        return "redirect:/music/list";
    }

}
