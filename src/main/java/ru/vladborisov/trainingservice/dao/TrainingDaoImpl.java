package ru.vladborisov.trainingservice.dao;

import org.springframework.stereotype.Repository;
import ru.vladborisov.trainingservice.model.Training;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class TrainingDaoImpl implements TrainingDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Training> getTodayTraining() {
        LocalDateTime todayTime = LocalDateTime.now();
        String today = todayTime.getYear() + "-" + todayTime.getMonthValue() + "-" + todayTime.getDayOfMonth();
        return entityManager.createQuery("from Training t where str(t.planTime) like :today", Training.class).setParameter("today", today + "%").getResultList().stream().findFirst();
    }

    @Override
    public void saveTraining(Training training) {
        entityManager.persist(training);
    }
}
