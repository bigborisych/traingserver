package ru.vladborisov.traingserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exercise")
@Getter
@Setter
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "exercise_id")
    private Long id;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name = "plan_load")
    private String planLoad;

    @Column(name = "fact_load")
    private String factLoad;

    @Column(name = "comment", length = 2048)
    private String comment;

    @ManyToMany(mappedBy = "exercises")
    private Set<Training> trainings;
}
