package ru.vladborisov.trainingservice.model;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_seq")
    @SequenceGenerator(name = "exercise_seq", sequenceName = "exercise_id_seq", allocationSize = 1)
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
