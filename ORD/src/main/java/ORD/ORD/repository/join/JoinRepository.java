package ORD.ORD.repository.join;

import ORD.ORD.domain.load.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface JoinRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserIdAndPw(String userId,String pw);

    Optional<User> findByUserId(String userId);


}
