package ORD.ORD.controller.join;

import ORD.ORD.domain.load.User;
import ORD.ORD.domain.login.JoinDTO;
import ORD.ORD.repository.join.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class JoinController {

    private final JoinRepository joinRepository;

    @GetMapping("/join")
    public String join_form(Model model){

        model.addAttribute("joinDTO",new JoinDTO());
        return "/login/join_form";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute @Valid JoinDTO joinDTO, Errors error){

        if(error.hasErrors()){
            return "/login/join_form";
        }

        joinRepository.save(new User(joinDTO.getUserId(),joinDTO.getPw(),joinDTO.getEmail(),"USER_ROLE"));

        return "redirect:/login";
    }




}
