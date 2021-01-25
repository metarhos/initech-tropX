package com.tropX.controller;


import com.tropX.service.RowsMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;


@RestController
public class RowsMonController {

    @Autowired
    RowsMonService service;

    @PreDestroy
    void contextWillClosed() {
        System.out.println("Context closed, good luck!");
    }



    @PostMapping("/rows/specification")
    String setSpecification(@RequestBody String specification) {

        service.addSpecification(specification);

        return "Specification added";
    }

}
