package ORD.ORD.controller.login;


import ORD.ORD.domain.load.User;
import ORD.ORD.domain.login.UserDTO;
import ORD.ORD.repository.load.LoadRepository;
import ORD.ORD.repository.join.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoadRepository loadRepository;
    private final JoinRepository joinRepository;

    @GetMapping("")
    public String basic(Model model){
        model.addAttribute("userDTO",new UserDTO());
        return "/login/login_form";
    }

    @GetMapping("/login")
    public String login_form(Model model){

        model.addAttribute("userDTO",new UserDTO());
        return "/login/login_form";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid UserDTO userDTO , Errors error , RedirectAttributes rttr){

        if(error.hasErrors()){
            log.info("asdadsa{}",error.getFieldError());
            return "/login/login_form";
        }


        Optional<User> user = joinRepository.findByUserIdAndPw(userDTO.getUserId(),userDTO.getPw());

        String userId = user.get().getUserId();

        rttr.addAttribute("userId",userId);

        return "redirect:/load";

    }

}
