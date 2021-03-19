package nl.hu.bep.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

    @GetMapping ({ "/hello"})
    public String firstPage(){
        return "Hello FancyFishPro World!";
    }
}
