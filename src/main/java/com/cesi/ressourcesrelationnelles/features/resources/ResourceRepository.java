package com.cesi.ressourcesrelationnelles.features.resources;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface ResourceRepository extends MongoRepository<Resource, Long> {
    @Query("{'resourcesTypes':?0}")
    List<Resource> findResourcesByType(int resourcesTypes);
}
