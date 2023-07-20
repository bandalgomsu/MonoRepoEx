package ORD.ORD.repository;

import ORD.ORD.domain.load.User;
import ORD.ORD.repository.join.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;




@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class test {

    @Autowired
    JoinRepository joinRepository ;

    @Test
    void lon(){
        joinRepository.save(new User("user","12345678","a11@naver.com","ROLE_USER"));
        Optional<User> user = joinRepository.findByUserId("user");

        log.info("asdadasdsa{}",user);

    }
}
