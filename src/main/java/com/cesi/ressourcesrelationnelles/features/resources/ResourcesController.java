package com.cesi.ressourcesrelationnelles.features.resources;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResourcesController {

    private final ResourceService resourceService;

    public ResourcesController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return resourceService.list();

    }

    @GetMapping("/resources/{id}")
    public Resource getResourceById(@PathVariable("id") Long id) {
        Optional<Resource> resource = resourceService.getById(id);
        if (resourceService.getById(id).isPresent()) {
            return resource.get();
        }
        return new Resource();
    }

    @PostMapping("/resources")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }


    @DeleteMapping("/resources/{id}")
    public void deleteResource(@PathVariable long id) {
        resourceService.delete(id);
    }

    @PutMapping("/resources/{id}")
    public Resource updateResource(@PathVariable long id, @RequestBody Resource resource) {
        resource.setId(id);
        return resourceService.updateResource(resource);
    }


}
