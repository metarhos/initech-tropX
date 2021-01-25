package com.tropX.controller;


import com.tropX.api.RepMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;


@RestController
public class RepMonController {

    @Autowired
    RepMonService service;

    @PreDestroy
    void contextWillClosed() {
        System.out.println("Context closed, good luck!");
    }

    @PostMapping("/exercise")
    String setExercise(@RequestBody String continousExercise) {//An array of motions taken every 1/10 sec. Need loadBalancer?

        //TODO saveExercise(continousExercise) to service for save data

        return "";
    }

    @PostMapping("/repetition")
    String setSpecification(@RequestBody String velocity) {//average 1 array, or same as exercise 1/10

        //TODO saveVelocity(velocity) to service for save data

        return "";
    }

    @GetMapping(value = "/repetitions")
    String getRepetitionsArray(){ //how to show array of array? What return?

        //TODO calculateRepetition() get array[][]

        return "";
    }

}
