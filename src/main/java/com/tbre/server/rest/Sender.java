package com.tbre.server.rest;

import com.tbre.server.database.OutputDataRepository;
import com.tbre.server.model.OutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Sender {

    @Autowired
    OutputDataRepository repository;

    @GetMapping("/getDataFrom")
    public ResponseEntity getData(@RequestBody Date timestamp){
        List<OutputData> repo = repository.findAll();
        List<OutputData> toReturn = new ArrayList<>();
        for(OutputData data : repo){
            if(data.getTimestamp().after(timestamp)){
                toReturn.add(data);
            }
        }

        repo = repo.stream().filter(a->a.getTimestamp().after(timestamp)).collect(Collectors.toList());
        return ResponseEntity.ok().body(repo);
    }

    @GetMapping("/getData")
    public ResponseEntity getData(){
        return ResponseEntity.ok().body(repository.findAll());
    }

}
