package com.cesi.ressourcesrelationnelles.features.resources;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ResourcesController {

    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        List<Resource> resources = new ArrayList<>();
        resources.add(new Resource(1, "bar", 0));
        resources.add(new Resource(2, "test", 1));
        return Collections.singletonList(new Resource());
    }

}
