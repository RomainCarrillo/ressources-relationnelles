package com.cesi.ressourcesrelationnelles.features.resources;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cesi.ressourcesrelationnelles.domain.Resource;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, Long> {
    
}
