package ORD.ORD.Controller;

import ORD.ORD.domain.IdDTO;
import ORD.ORD.domain.Load;
import ORD.ORD.domain.LoadDTO;
import ORD.ORD.repository.LoadRepository;
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
    @GetMapping("/load")
    public String load_Form(){
        return "/load";
    }
    @PostMapping("/load")
    public void save(@ModelAttribute LoadDTO loadDTO, Model model){

        Load load = new Load(loadDTO.getUserId(),loadDTO.getCode(),loadDTO.getClear());

        loadRepository.save(load);

        log.info("Pppp{}",loadDTO.getCode());
    }


    @PostMapping("/load/code")
    public String load(IdDTO id, Model model){
        log.info("asdasdasdadasdasdasd {}",id.getUserId());
        List<Load> byUserId = loadRepository.findByUserId(id.getUserId());
        List<String> code = new ArrayList<>();
        for (Load load : byUserId) {
            code.add(load.getCode());
        }
        model.addAttribute("code",code);

        return "/load";

    }

//    @PostMapping("/load/code")
//    public String code(){
//
//    }

    @ResponseBody
    @GetMapping("/load/app")
    public String app_load(){
        return null;
    }
}
