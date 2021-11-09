package com.jeremi.grzegorz.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/")
public class BackController {

    @GetMapping("")
    public ResponseEntity<?> getResponse() throws IOException{
        URL url = new URL("https://google.com/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");


        return new ResponseEntity<>(
                FullResponseBuilder.getFullResponse(con),
                HttpStatus.OK);
    }
}
