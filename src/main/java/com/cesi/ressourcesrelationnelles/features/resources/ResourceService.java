package com.cesi.ressourcesrelationnelles.features.resources;


import com.cesi.ressourcesrelationnelles.domain.Resource;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository commentRepository) {
        this.resourceRepository = commentRepository;
    }

    public List<Resource> list() {
        return resourceRepository.findAll();
    }

    public Resource createResource(Resource resource) {

        return resourceRepository.save(resource);
    }

    public void delete(long id) {
        resourceRepository.deleteById(id);
    }

    public Resource updateResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Optional<Resource> getById(long id) {
        return resourceRepository.findById(id);
    }
}

