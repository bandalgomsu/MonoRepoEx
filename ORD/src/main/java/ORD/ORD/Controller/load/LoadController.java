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

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoadController {
    private final LoadRepository loadRepository;
    @GetMapping("/load")
    public String load_Form(){
        return "/load/load_form";
    }
    @PostMapping("/load")
    public void save(@ModelAttribute LoadDTO loadDTO){

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

        return "/load/load_form";

    }

    @ResponseBody
    @GetMapping("/load/app")
    public String app_load(){
        return null;
    }
}
