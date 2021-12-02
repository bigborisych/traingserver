package ru.vladborisov.trainingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vladborisov.trainingservice.model.Training;
import ru.vladborisov.trainingservice.service.TrainingService;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping
    public ResponseEntity<Training> saveTraining(@RequestBody Training training){
        if (training == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        LocalDateTime dateTime = LocalDateTime.now();
        training.setCreateTime(dateTime);
        training.setPlanTime(dateTime);
        trainingService.saveTraining(training);
        return new ResponseEntity<>(training, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Training> getTodayTraining(){
        Optional<Training> todayTraining = trainingService.getTodayTraining();
        return todayTraining.map(training -> new ResponseEntity<>(training, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
