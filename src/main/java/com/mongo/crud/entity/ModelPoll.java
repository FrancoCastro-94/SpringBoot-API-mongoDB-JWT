package com.mongo.crud.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Document
public class ModelPoll implements Serializable {

    @Id
    private String id;

    @DateTimeFormat(iso=ISO.DATE)
    private LocalDate fecha;

    private String question;

    private HashMap<String, Integer> fielsAndCounts;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public HashMap<String, Integer> getFielsAndCounts() {
        return fielsAndCounts;
    }

    public void setFielsAndCounts(HashMap<String, Integer> fielsAndCounts) {
        this.fielsAndCounts = fielsAndCounts;
    }

    
    
    
    

}
