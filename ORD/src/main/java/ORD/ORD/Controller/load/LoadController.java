package ORD.ORD.Controller.load;

import ORD.ORD.domain.load.IdDTO;
import ORD.ORD.domain.load.Load;
import ORD.ORD.domain.load.LoadDTO;
import ORD.ORD.repository.load.LoadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoadController {
    private final LoadRepository loadRepository;
    @GetMapping("/load/{uid}")
    public String load_Form(@PathVariable("uid") String uid,Model model){

        List<Load> load = loadRepository.findByUserIdOrderByClear(uid);
        model.addAttribute("clear",load.get(load.size()-1));
        model.addAttribute("load",load);
        model.addAttribute(uid);
        return "/load/load_form";
    }
    @PostMapping("/load/{uid}")
    public String save(@ModelAttribute LoadDTO loadDTO,@PathVariable("uid") String uid,Model model){

        Load load = new Load(uid,loadDTO.getCode(),loadDTO.getClear());

        loadRepository.save(load);

        model.addAttribute("uid",uid);

        return "redirect:/load/"+uid;

    }



    @ResponseBody
    @GetMapping("/load/app")
    public String app_load(){
        return null;
    }
}
