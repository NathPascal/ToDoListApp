package fr.fms.entities;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime dueDateTime;
    private String description;


    public Task() {}

    public Task(Long id, String name, LocalDateTime dueDateTime, String description) {
        this.id = id;
        this.name = name;
        this.dueDateTime = dueDateTime;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDueDate() {
        return dueDateTime;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDateTime = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
