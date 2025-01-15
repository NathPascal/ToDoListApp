package fr.fms.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=3, max=50)
    private String name;

    @OneToMany(mappedBy = "category")
    private Collection<Task> tasks;

    public Category(){}

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
