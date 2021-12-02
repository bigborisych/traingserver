package ru.vladborisov.trainingservice.service;

import ru.vladborisov.trainingservice.model.Training;

import java.util.Optional;

public interface TrainingService {
    Optional<Training> getTodayTraining();
    void saveTraining(Training training);
}
