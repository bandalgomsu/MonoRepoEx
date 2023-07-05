package ORD.ORD.Controller.login;


import ORD.ORD.domain.load.User;
import ORD.ORD.domain.login.UserDTO;
import ORD.ORD.repository.load.LoadRepository;
import ORD.ORD.repository.login.LoginRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoadRepository loadRepository;
    private final LoginRepository loginRepository;

    @GetMapping("/login")
    public String login_form(){
        loginRepository.save(new User("asd","asd"));
        return "/login/login_form";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@ModelAttribute UserDTO userDTO){

        List<User> User = loginRepository.findByUserId(userDTO.getUserId());
        User user = User.get(0);
        log.info("asdasd {} {} ",user.getUserId(),user.getPw());
        String userId = user.getUserId();

        if (user == null){
            return "redirect:/";
        }

        return "redirect:/load";


    }

}
