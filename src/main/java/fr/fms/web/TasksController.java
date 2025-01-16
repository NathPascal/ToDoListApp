package fr.fms.web;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TaskRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Task;
import fr.fms.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TasksController {

    @Autowired
    TasksService tasksService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/tasks")
    public String tasks(Model model, @RequestParam(name="page", defaultValue = "0") int page,
                        @RequestParam(name = "keyword", defaultValue = "") String kw,
                        @RequestParam(name="categoryId", defaultValue = "0")Long categoryId){
        Page<Task> tasks;
                if (categoryId > 0){
                    Category category = categoryRepository.findById(categoryId).orElse(null);
                    tasks = taskRepository.findByCategoryAndDescriptionContains(category, kw, PageRequest.of(page, 5));
                }else {
        tasks = taskRepository.findByDescriptionContains(kw, PageRequest.of(page, 5));}

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("listTasks", tasks);
        model.addAttribute("pages", new int[tasks.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        model.addAttribute("selectedCategoryId", categoryId);

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
