package com.cesi.ressourcesrelationnelles.features.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {

    @GetMapping("/resources")
    public String index() {
        return "Resources Controller emplacement ";
    }

}
