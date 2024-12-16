package ORD.ORD.Controller.join;

import ORD.ORD.domain.load.User;
import ORD.ORD.domain.login.JoinDTO;
import ORD.ORD.repository.join.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class JoinController {

    private final JoinRepository joinRepository;

    @GetMapping("/join")
    public String join_form(){
        return "/login/join_form";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute JoinDTO joinDTO){

        joinRepository.save(new User(joinDTO.getUserId(),joinDTO.getPw(),joinDTO.getEmail()));

        return "redirect:/login";
    }




}
