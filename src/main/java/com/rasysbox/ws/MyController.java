package com.rasysbox.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyRepository myRepository;

    @Autowired
    public MyController(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    @GetMapping("/data")
    public void getDataFromDatabase() {
        myRepository.executeQuery();
    }
}

