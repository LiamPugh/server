package com.tbre.server.rest;

import com.tbre.server.database.OutputDataRepository;
import com.tbre.server.model.InputData;
import com.tbre.server.model.OutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Receiver {

    @Autowired
    OutputDataRepository repository;

    @PostMapping("/addData")
    public void receiveData(@RequestBody InputData inputData){
        repository.save(new OutputData(inputData.getTimestamp(),inputData.getName()));
    }

}
