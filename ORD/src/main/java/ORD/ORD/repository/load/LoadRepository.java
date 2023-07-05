package ORD.ORD.repository.load;

import ORD.ORD.domain.load.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LoadRepository extends JpaRepository<Load,Long> {
    List<Load> findByUserId(String userId);



}
