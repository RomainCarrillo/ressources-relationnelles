package com.cesi.ressourcesrelationnelles.features.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.ressourcesrelationnelles.domain.Resource;

@RestController
public class ResourcesController {

	@Autowired
    private ResourceRepository ressourceRepository;

    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return ressourceRepository.findAll();

    }

    @GetMapping("/resources/{id}")
    public Resource getResourceById(@PathVariable("id") Long id) {
        Optional<Resource> resource = ressourceRepository.findById(id);
        if (resource.isPresent()) {
            return resource.get();
        }
        return new Resource();
    }

    @PostMapping("/resources")
    public Resource createResource(@RequestBody Resource resource) {
        return ressourceRepository.insert(resource);
    }


    @DeleteMapping("/resources/{id}")
    public void deleteResource(@PathVariable long id) {
        ressourceRepository.deleteById(id);
    }

//    @PutMapping("/resources/{id}")
//    public Resource updateResource(@PathVariable long id, @RequestBody Resource resource) {
//        resource.setId(id);
//        return ressourceRepository.updateResource(resource);
//    }


}
