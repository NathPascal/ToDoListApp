package fr.fms.web;

import fr.fms.dao.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TasksController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public String tasks(){
        return "tasks";
    }



}
