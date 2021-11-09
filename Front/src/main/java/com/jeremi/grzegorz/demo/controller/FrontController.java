package com.jeremi.grzegorz.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/")
public class FrontController {

    @GetMapping("")
    public ResponseEntity<?> getResponse() throws IOException {

        return new ResponseEntity<>(
                readFile("target/classes/static/index.html", StandardCharsets.UTF_8),
                HttpStatus.OK);
    }

    @GetMapping("connect/")
    public ResponseEntity<?> getConnect() throws IOException {
        URL url = new URL("http://back:8080/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");


        return new ResponseEntity<>(
                FullResponseBuilder.getFullResponse(con),
                HttpStatus.OK);
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
