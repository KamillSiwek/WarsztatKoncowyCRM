package pl.coderslab.warsztatkoncowycrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztatkoncowycrm.entities.Project;


public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findProjectById(Long id);


}
