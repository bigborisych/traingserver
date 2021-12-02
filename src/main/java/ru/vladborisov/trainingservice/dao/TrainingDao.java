package ru.vladborisov.trainingservice.dao;


import ru.vladborisov.trainingservice.model.Training;

import java.util.Optional;

public interface TrainingDao {

    Optional<Training> getTodayTraining();
    void saveTraining(Training training);
}
