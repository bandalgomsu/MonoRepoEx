package ORD.ORD.repository.login;

import ORD.ORD.domain.load.Load;
import ORD.ORD.domain.load.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LoginRepository extends JpaRepository<User,Long> {
    List<User> findByUserId(String userId);
}
