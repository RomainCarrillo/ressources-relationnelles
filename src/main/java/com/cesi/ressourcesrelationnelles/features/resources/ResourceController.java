package com.cesi.ressourcesrelationnelles.features.resources;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("/resource")
    @CrossOrigin("*")
    public ResponseEntity<Resource> getResource(@RequestParam String id) {
        Optional<Resource> resource;
        resource = resourceRepository.findById(id);
        return resource.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/resources")
    @CrossOrigin("*")
    public ResponseEntity<List<Resource>> getResources(@RequestParam(required = false) Long resourceType, @RequestParam(required = false) String creatorId) {
        if(resourceType != null || creatorId != null){
            List<Resource> resourceList = null;
            if(resourceType != null && creatorId != null)
                resourceList = resourceRepository.findResourcesByUserAndType(creatorId, Math.toIntExact(resourceType));
            else if(resourceType != null)
                resourceList = resourceRepository.findResourcesByType(Math.toIntExact(resourceType));
            else if(creatorId != null)
                resourceList = resourceRepository.findResourcesByCreatorId(creatorId);

            if(!resourceList.isEmpty())
                return new ResponseEntity<>(resourceList, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // If no argument, get every resource
        else return new ResponseEntity<>(resourceRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createResource")
    @CrossOrigin("*")
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        try {
            Resource _resource = resourceRepository.save(resource);
            return new ResponseEntity<>(_resource, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteResource")
    @CrossOrigin("*")
    public ResponseEntity<HttpStatus> deleteResource(@RequestParam String id) {
        try {
            resourceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
