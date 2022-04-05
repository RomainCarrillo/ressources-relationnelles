package com.cesi.ressourcesrelationnelles.features.resources;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface ResourceRepository extends MongoRepository<Resource, String> {
    @Query("{'resourceType':?0}")
    List<Resource> findResourcesByType(int resourceType);

    @Query("{'creatorId':?0}")
    List<Resource> findResourcesByCreatorId(String creatorId);

    //@Query("{'creatorId':?0, 'resourceType':?1}")
    @Query("{'creatorId' : ?0, 'resourceType' : ?1}")
    List<Resource> findResourcesByUserAndType(String creatorId, int resourceType);
}
