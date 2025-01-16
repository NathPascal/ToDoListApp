package fr.fms;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TaskRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ToDoListJpasTests {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void test_save_task(){

        Category découverte = categoryRepository.save(new Category(null, "découverte"));
        taskRepository.save(new Task(null, "les Pyrénées", LocalDateTime.of(2025, 4, 15, 10, 00), "organiser des randonnées", découverte ));

        Task task = taskRepository.findByDescriptionContains("organiser", PageRequest.of(0,1) ).getContent().get(0);

        assertEquals("organiser des randonnées", task.getDescription());

    }
}
