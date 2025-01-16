package fr.fms.web;

import fr.fms.entities.Category;
import fr.fms.entities.Task;
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
        workCategory.setName("Travail");
        exampleTasks.add(new Task(null, "Rapport hebdomadaire", LocalDateTime.of(2025,2,8, 9, 0
        ), "Rédiger et soumettre le rapport", workCategory));

        Category hobbyCategory = new Category();
        hobbyCategory.setName("Loisirs");
        exampleTasks.add(new Task(null, "Randonnée montagne", LocalDateTime.of(2025, 4, 15, 10, 00), "Faire une randonnée en montagne",hobbyCategory));

        hobbyCategory.setName("Loisirs");
        exampleTasks.add(new Task(null, "Jeux vidéos", LocalDateTime.of(2025, 2, 15, 13, 00), "Jouer à des jeux vidéos", hobbyCategory));

        model.addAttribute("exampleTasks", exampleTasks);
        return "home";
    }

    @GetMapping("/403")
    public String error(){
        return "403";
    }
    
}
