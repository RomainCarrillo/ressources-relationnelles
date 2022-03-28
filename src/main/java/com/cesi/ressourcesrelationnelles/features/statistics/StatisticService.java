package com.cesi.ressourcesrelationnelles.features.statistics;

import com.cesi.ressourcesrelationnelles.domain.Statistic;

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

    public void delete(long statistic){ statisticRepository.deleteById(statistic); }

    public Statistic update(Statistic statistic){ return statisticRepository.save(statistic);}


}
