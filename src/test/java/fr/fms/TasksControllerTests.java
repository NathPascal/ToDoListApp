package fr.fms;

import fr.fms.entities.Task;
import fr.fms.service.TasksService;
import fr.fms.web.TasksController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TasksControllerTests {

    private MockMvc mockMvc;

    @Mock
    private TasksService tasksService;

    @InjectMocks
    private TasksController tasksController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tasksController).build();
    }

    @Test
    public void testSaveTask() throws Exception {
        Task task = new Task(null, "Task 1", LocalDateTime.of(2025, 3, 15, 10, 30), "Description 1");

        mockMvc.perform(post("/saveTask")
                        .param("name", task.getName())
                        .param("description", task.getDescription())
                        .param("dueDate", task.getDueDate().toString()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasks"));

        verify(tasksService, times(1)).saveTask(any(Task.class));
    }
}
