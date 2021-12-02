package ru.vladborisov.trainingservice.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "training")
@Getter
@Setter
public class Training {
    @Id
    @Column(name = "training_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_seq")
    @SequenceGenerator(name = "training_seq", sequenceName = "training_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "training_name", nullable = false)
    private String trainingName;

    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createTime;

    @Column(name = "plan_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime planTime;

    @ManyToMany(cascade = {CascadeType.ALL})
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "training_exercise",
            joinColumns = {@JoinColumn(name = "training_id")},
            inverseJoinColumns = {@JoinColumn(name = "exericise_id")}
    )
    private Set<Exercise> exercises;
}
