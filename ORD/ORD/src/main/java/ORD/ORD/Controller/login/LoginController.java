package ORD.ORD.Controller.login;


import ORD.ORD.domain.load.User;
import ORD.ORD.domain.login.UserDTO;
import ORD.ORD.repository.load.LoadRepository;
import ORD.ORD.repository.join.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoadRepository loadRepository;
    private final JoinRepository joinRepository;

    @GetMapping("/login")
    public String login_form(){
        return "/login/login_form";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO){

        List<User> User = joinRepository.findByUserIdAndPw(userDTO.getUserId(),userDTO.getPw());

        if (User.size() == 0){
            return "redirect:/login";
        }

        String userId = User.get(0).getUserId();


        return "redirect:/load/"+userId;

    }

}
