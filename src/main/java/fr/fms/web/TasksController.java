package fr.fms.web;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TaskRepository;
import fr.fms.entities.Task;
import fr.fms.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TasksController {

    @Autowired
    TasksService tasksService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/tasks")
    public String tasks(Model model, @RequestParam(name = "keyword", defaultValue = "") String kw){
        List<Task> tasks = taskRepository.findAll();
        tasks = taskRepository.findByDescriptionContains(kw);

        model.addAttribute("listTasks", tasks);
        model.addAttribute("keyword", kw);

        return "tasks";
    }

    @GetMapping("/addNewTask")
    public String addNewTask(Model model){
        model.addAttribute("task", new Task());
        model.addAttribute("categories", tasksService.getCategories());
        return "task";
    }

    @PostMapping("/saveTask")
    public String saveTask(Model model, @Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "task";
        tasksService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id){
        tasksService.delete(id);
        return "redirect:/tasks";
    }

    @GetMapping("/edit")
    public String edit (Model model, @RequestParam Long id) {
        Task task = tasksService.getTaskById(id);
        if (task == null) {
            return "redirect:/tasks";
        }
        model.addAttribute("task", task);
        model.addAttribute("categories", tasksService.getCategories());
        return "edit";
    }
}
