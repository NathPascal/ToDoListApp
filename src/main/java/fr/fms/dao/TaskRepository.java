package fr.fms.dao;

import fr.fms.entities.Category;
import fr.fms.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByDescriptionContains(String kw, Pageable pageable);

    Page<Task> findByCategoryAndDescriptionContains(Category category, String kw, Pageable pageable);
}
