package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import com.cesi.ressourcesrelationnelles.repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    private StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public List<Statistic> liste(){
        return statisticRepository.findAll();
    }

    public Statistic create(Statistic statistic){
        return statisticRepository.save(statistic);
    }


}
