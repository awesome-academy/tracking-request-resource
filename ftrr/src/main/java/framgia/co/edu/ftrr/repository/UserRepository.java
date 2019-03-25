package framgia.co.edu.ftrr.repository;

import framgia.co.edu.ftrr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getOneByEmail(String email);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    User findByEmail(String email);

    List<User> findAllByDivisionAndRoleIn(Integer division, Integer[] role);
}