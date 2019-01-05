package pl.coderslab.warsztatkoncowycrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztatkoncowycrm.entities.Task;
import pl.coderslab.warsztatkoncowycrm.entities.User;

public interface TaskRepository extends JpaRepository<Task, Long> {


    Task findTaskByTopic(String task);
    Task findTaskById(Long id);
    
}
