package com.tbre.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class InputData {

    @Id
    private Long id;

    private Date timestamp;
    private String name;

    public InputData(Date timestamp, String name) {
        this.timestamp = timestamp;
        this.name = name;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
