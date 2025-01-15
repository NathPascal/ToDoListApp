package fr.fms;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TaskRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ToDoListApplication implements CommandLineRunner {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		Category urgent = categoryRepository.save(new Category(null, "Urgent"));
//		Category travail = categoryRepository.save(new Category(null, "Travail"));
//		Category personnel = categoryRepository.save(new Category(null, "Personnel"));
//		Category santé = categoryRepository.save(new Category(null, "Santé"));
//		Category éducation = categoryRepository.save(new Category(null, "Education"));
//		Category courses = categoryRepository.save(new Category(null, "Courses"));
//		Category loisirs = categoryRepository.save(new Category(null, "Loisirs"));
//		Category finances = categoryRepository.save(new Category(null, "Finances"));
//		Category projets = categoryRepository.save(new Category(null, "Projets"));
//		Category voyages = categoryRepository.save(new Category(null, "Voyages"));
//
//		LocalDateTime dateTime1 = LocalDateTime.of(2025, 3, 15, 10, 30);
//		LocalDateTime dateTime2 = LocalDateTime.of(2025, 4, 10, 14, 0);
//		LocalDateTime dateTime3 = LocalDateTime.of(2025, 5, 5, 18, 0);
//
//		taskRepository.save(new Task(null, "Rendez-vous médecin", dateTime1, "bilan annuel", santé));
//		taskRepository.save(new Task(null, "Réunion de travail", dateTime2, "Présentation du projet", travail));
//		taskRepository.save(new Task(null, "Anniversaire de Jean", dateTime3, "Acheter un cadeau", personnel));
	}
}





