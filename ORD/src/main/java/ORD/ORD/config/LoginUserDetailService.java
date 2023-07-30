package ORD.ORD.config;

import ORD.ORD.domain.login.User;
import ORD.ORD.domain.login.User;
import ORD.ORD.repository.join.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import java.util.Optional;

import static org.springframework.security.core.userdetails.User.*;

@RequiredArgsConstructor
@Component
@Slf4j
public class LoginUserDetailService implements UserDetailsService {
    private final JoinRepository joinRepository;


    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        Optional<User> findOne = joinRepository.findByUserId(insertedUserId);
        User user = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserId())
                .password(user.getPw())
                .roles("USER")
                .build();
    }

}
