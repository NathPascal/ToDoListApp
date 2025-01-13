package fr.fms.web;

import fr.fms.dao.TaskRepository;
import fr.fms.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TasksController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public String tasks(Model model){
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("listTasks", tasks);

        return "tasks";
    }

    @GetMapping("/newTask")
    public String newTask(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "newTask";
    }

}
