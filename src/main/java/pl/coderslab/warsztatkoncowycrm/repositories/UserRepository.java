package pl.coderslab.warsztatkoncowycrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztatkoncowycrm.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByName(String user);

    User findUserById(Long id);


}
