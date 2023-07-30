package ORD.ORD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
@EnableWebSecurity
public class SecurityConfig  {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/join").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")	// [A] 커스텀 로그인 페이지 지정
                        .loginProcessingUrl("/login")
                        .usernameParameter("userId")	// [C] submit할 아이디
                        .passwordParameter("pw")	// [D] submit할 비밀번호
                        .defaultSuccessUrl("/load", true)
                        .permitAll()
                )
                .logout(withDefaults());

        return http.build();

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new LoginPasswordEncoder();
    }







}
