package codegym.vn.controller;

import codegym.vn.model.KhaiBao;
import codegym.vn.repository.IKhaiBaoRepository;
import codegym.vn.repository.KhaiBaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("khaiBao")
public class KhaiBaoController {

    private IKhaiBaoRepository iKhaiBaoRepository=new KhaiBaoRepository();

//    @Autowired
//    public KhaiBaoController(IKhaiBaoRepository iKhaiBaoRepository) {
//        this.iKhaiBaoRepository = iKhaiBaoRepository;
//    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        KhaiBao khaiBao = new KhaiBao();
        String[] gioiTinh = new String[]{"Nam", "Nữ", "Khác"};
        String[] quocTich = new String[]{"Việt Nam", "Lào", "Thái Lan"};
        String[] thongTinDiLai=new String[]{"Tàu Bay","Tàu Thuyền","Ô tô","Khác"};
        String[] yKien=new String[]{"Có","Không"};
        model.addAttribute("khaiBao", khaiBao);
        model.addAttribute("gioiTinh", gioiTinh);
        model.addAttribute("quocTich", quocTich);
        model.addAttribute("thongTinDiLai",thongTinDiLai);
        model.addAttribute("yKien",yKien);
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "khaiBao") KhaiBao khaiBao){
        iKhaiBaoRepository.create(khaiBao);
        return "redirect:/khaiBao/list";
    }
    @GetMapping(value = "/list")
    public String display(Model model){
        model.addAttribute("khaiBao",iKhaiBaoRepository.findAll());
        return "list";
    }

}
