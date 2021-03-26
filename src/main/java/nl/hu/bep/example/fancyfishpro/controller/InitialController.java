package nl.hu.bep.example.fancyfishpro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

    @GetMapping("/hello")
    public String answerMe(){
        return "Hello FancyFishPro World!";
    }
}
