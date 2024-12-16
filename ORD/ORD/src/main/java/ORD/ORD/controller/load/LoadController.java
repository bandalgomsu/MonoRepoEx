package ORD.ORD.controller.load;

import ORD.ORD.domain.load.Load;
import ORD.ORD.domain.load.LoadDTO;
import ORD.ORD.repository.load.LoadRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoadController {
    private final LoadRepository loadRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/load")
    public String load_Form(Principal principal, Model model){
        String userId=principal.getName();
        log.info("ASDasdasd{}",userId);
        List<Load> load = loadRepository.findByUserIdOrderByClear(userId);

        if(load.size() == 0){
            model.addAttribute("userId",userId);
            model.addAttribute("clear","");
            model.addAttribute("code"," ");
            model.addAttribute("load",new Load());

            return "/load/load_form";
        }

        model.addAttribute("userId",userId);
        model.addAttribute("clear",load.get(load.size()-1).getClear());
        model.addAttribute("code",load.get(load.size()-1).getCode());
        model.addAttribute("load",load);

        return "/load/load_form";
    }
    @PostMapping("/load/save")
    public String save(@ModelAttribute @Valid LoadDTO loadDTO, Principal principal, Model model){

        String userId = principal.getName();

        String pattern = "^([0-9a-zA-Z!@#$%^&*()_+]{11}$)";


        if(Pattern.matches(pattern,loadDTO.getCode())){
            loadRepository.save(new Load(userId,"-load "+loadDTO.getCode(),loadDTO.getClear()));
        }
        else {
            loadRepository.save(new Load(userId, loadDTO.getCode(), loadDTO.getClear()));
        }
        return "redirect:/load";

    }



    @ResponseBody
    @GetMapping("/load/app")
    public String app_load(){
        return null;
    }
}
