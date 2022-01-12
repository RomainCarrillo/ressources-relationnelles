package com.cesi.ressourcesrelationnelles.service;


import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository commentRepository) {
        this.resourceRepository = commentRepository;
    }

    public List<Resource> list() {
        return resourceRepository.findAll();
    }

    public void createResources(Resource resource) {
        resourceRepository.save(resource);
    }
}

