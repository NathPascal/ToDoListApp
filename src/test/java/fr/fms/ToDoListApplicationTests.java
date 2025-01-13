//package fr.fms;
//
//import fr.fms.dao.TaskRepository;
//import fr.fms.entities.Task;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.text.MessageFormat;
//import java.time.Duration;
//import java.time.Instant;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//class ToDoListAppApplicationTests {
//
//	@Autowired
//	TaskRepository taskRepository;
//
////	@Test
////	void contextLoads() {
////	}
//
//	private static Instant startedAt;
//
//    @BeforeEach
//    public void beforeEachTest() {
//        System.out.println("avant chaque test");
//    }
//
//    @AfterEach
//    public void afterEachTest() {
//        System.out.println("après chaque test");
//    }
//
//    @BeforeAll
//    public static void initStartingTime() {
//        System.out.println("Appel avant tous les tests");
//        startedAt = Instant.now();
//    }
//
//    @AfterAll
//    public static void showTestDuration() {
//        System.out.println("Appel après tous les tests");
//        final Instant endedAt = Instant.now();
//        final long duration = Duration.between(startedAt, endedAt).toMillis();
//        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
//    }
//
//    @ParameterizedTest(name = "{0} * 0 doit être égal à 0")
//    @ValueSource(ints = {1, 2, 42, 1011, 5089})
//    public void multiply_shouldReturnZero(int arg) {
//        assertEquals(0, arg * 0);
//    }
//
//    @Test
//    void createTask() {
//        taskRepository.save(new Task(null, "Rendez-vous médecin", localDateTime.of, "bilan annuel"));
//        taskRepository.save(new Task(null, "Réunion de travail", null, "Présentation du projet"));
//        taskRepository.save(new Task(null, "Anniversaire de Jean", null, "Acheter un cadeau"));
//    }
//
//
//}
