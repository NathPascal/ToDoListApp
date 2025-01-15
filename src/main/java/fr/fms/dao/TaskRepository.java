package fr.fms.dao;

import fr.fms.entities.Category;
import fr.fms.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDescriptionContains(String kw);

    List<Task> findByCategoryAndDescriptionContains(Category category, String kw);
}
