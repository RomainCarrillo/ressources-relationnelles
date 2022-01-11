package com.cesi.ressourcesrelationnelles.features.statistics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class statisticsController {
    @GetMapping("/statistics")
    public String index() {
        return "Hello World !";
    }
}
