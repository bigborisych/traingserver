package ru.vladborisov.traingserver.model;


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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "training_name", nullable = false)
    private String trainingName;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "plan_time")
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
