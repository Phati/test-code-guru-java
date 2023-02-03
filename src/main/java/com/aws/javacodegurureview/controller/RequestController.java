package com.aws.javacodegurureview.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Log4j
@RestController
@RequestMapping("/api")
public class RequestController {
    @GetMapping("/ping")
    public ResponseEntity<?> getResponse(){
        Map<String,Object> response = new HashMap<>();
        try{
               response.put("java-version",System.getProperty("java.version"));
        }
        catch (Exception e){
            response.put("error",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
