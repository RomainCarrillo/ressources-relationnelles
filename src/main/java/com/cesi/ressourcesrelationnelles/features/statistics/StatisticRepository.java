package com.cesi.ressourcesrelationnelles.features.statistics;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cesi.ressourcesrelationnelles.domain.Statistic;

@Repository
public interface StatisticRepository extends MongoRepository<Statistic, Long> {
}
