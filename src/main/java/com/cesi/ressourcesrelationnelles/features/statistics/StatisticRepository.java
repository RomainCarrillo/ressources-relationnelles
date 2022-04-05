package com.cesi.ressourcesrelationnelles.features.statistics;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface StatisticRepository extends MongoRepository<Statistic, Long> {
    @Query("{'id_ressource':?0}")
    List<Statistic> findStatisticsByResource(Long id);
}
