package com.rasysbox.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<String> getDataFromDatabase(@RequestParam(name = "msisdn") String msisdn) {
        return new ResponseEntity<>(myRepository.executeQuery(msisdn), HttpStatus.OK);
    }
}

