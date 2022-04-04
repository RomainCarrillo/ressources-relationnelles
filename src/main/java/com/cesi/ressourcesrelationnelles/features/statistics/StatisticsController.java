package com.cesi.ressourcesrelationnelles.features.statistics;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.ressourcesrelationnelles.domain.Statistic;

@RestController
public class StatisticsController {

	
	private StatisticRepository statisticRepository;


    @GetMapping("/statistics")
    public List<Statistic> getAllStatistics(){
        return statisticRepository.findAll();
    }

    @PostMapping("/statistics")
    public Statistic createStatistic(@RequestBody Statistic stat){
        return statisticRepository.insert(stat);
    }

    @DeleteMapping("/statistics/{id}")
    public void deleteStatisticsById(@PathVariable long id){
        statisticRepository.deleteById(id);
    }

//    @PutMapping("/statistics/{id}")
//    public Statistic updateSatisticById(@PathVariable long id, @RequestBody Statistic statistic){
//        statistic.setId(id);
//        return statisticRepository.update(statistic);
//    }



}
