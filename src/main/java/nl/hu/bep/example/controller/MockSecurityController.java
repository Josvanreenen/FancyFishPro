package nl.hu.bep.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockSecurityController {
    @RequestMapping({'/openaccess'})
    public String openlyAvailableCall(){
    return "Hello Open World!";
    }
}
