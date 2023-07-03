package ORD.ORD.repository;

import ORD.ORD.domain.Load;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@Slf4j
@SpringBootTest
public class RepositoryTest {

    @Autowired
    LoadRepository loadRepository;

//    @BeforeEach()
//    void delete(){
//        loadRepository.deleteAll();
//    }
    @Test
    void save(){
        loadRepository.deleteAll();
        Load dao = new Load();
        dao.setUserId("asd");
        dao.setCode("asd");
        dao.setClear(1111231231);
        loadRepository.save(dao);

    }
    @Test
    void read(){
        List<Load> all = loadRepository.findAll();

        for (Load dao : all) {
            log.info("user_id: {}",dao.getUserId());
            log.info("code: {}",dao.getCode());
            log.info("clear: {}",dao.getClear());
        }



    }
    @Test
    void read_userName(){
        List<Load> user = loadRepository.findByUserId("asd");

        for (Load dao : user) {
            log.info("dd: {}",dao.getUserId());
            log.info("dd: {}",dao.getCode());
            log.info("dd: {}",dao.getClear());

        }

    }




}
