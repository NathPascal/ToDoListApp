package fr.fms;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TaskRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Task;
import fr.fms.service.TasksService;
import fr.fms.web.TasksController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// test pour vérifier si la page tasks est correctement renvoyée avec un mot-clé spécifique.

@WebMvcTest(TasksController.class)
class TasksControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TasksService tasksService;

    @MockBean
    private TaskRepository taskRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    void testGetTasks() throws Exception {
        when(categoryRepository.findAll()).thenReturn(List.of(new Category(null, "Travail")));
        when(taskRepository.findByDescriptionContains(anyString(), any(PageRequest.class)))
                .thenReturn(new PageImpl<>
                        (List.of(new Task(null, "Réunion de travail",
                                LocalDateTime.of(2025, 4, 12, 14, 00),
                                "Présentation du projet", new Category(null, "travail")))));

        this.mockMvc.perform(get("/tasks")
                        .param("keyword", "projet")
                        .param("page", "0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("listTasks"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(view().name("tasks"));

    }
}
