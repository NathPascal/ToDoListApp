package fr.fms.web;

import fr.fms.entities.Category;
import fr.fms.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        List<Task> exampleTasks = new ArrayList<>();

        Category workCategory = new Category();
        workCategory.setName("Work");
        exampleTasks.add(new Task(null, "Task 1", LocalDateTime.now().plusDays(1), "Description for Task 1", workCategory));

        Category personalCategory = new Category();
        personalCategory.setName("Personal");
        exampleTasks.add(new Task(null, "Task 2", LocalDateTime.now().plusDays(2), "Description for Task 2", personalCategory));

        Category shoppingCategory = new Category();
        shoppingCategory.setName("Shopping");
        exampleTasks.add(new Task(null, "Task 3", LocalDateTime.now().plusDays(3), "Description for Task 3", shoppingCategory));

        model.addAttribute("exampleTasks", exampleTasks);
        return "home";
    }
}
