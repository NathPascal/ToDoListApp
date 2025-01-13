package fr.fms;

import fr.fms.dao.TaskRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		LocalDateTime dateTime1 = LocalDateTime.of(2025, 3, 15, 10, 30);
//		LocalDateTime dateTime2 = LocalDateTime.of(2025, 4, 10, 14, 0);
//		LocalDateTime dateTime3 = LocalDateTime.of(2025, 5, 5, 18, 0);
//
//		taskRepository.save(new Task(null, "Rendez-vous médecin", dateTime1, "bilan annuel"));
//		taskRepository.save(new Task(null, "Réunion de travail", dateTime2, "Présentation du projet"));
//		taskRepository.save(new Task(null, "Anniversaire de Jean", dateTime3, "Acheter un cadeau"));
	}
}





