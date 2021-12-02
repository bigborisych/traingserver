package ru.vladborisov.trainingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladborisov.trainingservice.dao.TrainingDao;
import ru.vladborisov.trainingservice.model.Training;

import java.util.Optional;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingDao trainingDao;

    @Override
    public Optional<Training> getTodayTraining() {
        return trainingDao.getTodayTraining();
    }

    @Override
    public void saveTraining(Training training) {
        trainingDao.saveTraining(training);
    }
}
