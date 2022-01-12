package com.cesi.ressourcesrelationnelles.features.statistics;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import com.cesi.ressourcesrelationnelles.service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatisticsController {
    private StatisticService statisticService;

    public StatisticsController(StatisticService statService){
        this.statisticService = statService;
    }

    //@GetMapping("/statistics")
    //public ArrayList<Statistic> getALlStatistics() {
    //    ArrayList<Statistic> listStats = new ArrayList<>();
    //    listStats.add(new Statistic(1, 1, 10));
    //    listStats.add(new Statistic(2, 2, 100));
    //    listStats.add(new Statistic(10, 15, 1000));
    //    return listStats;
    //}

    @GetMapping("/statistics")
    public List<Statistic> getAllStatistics(){
        return statisticService.liste();
    }

    @PostMapping("/statistics")
    public Statistic createStatistic(@RequestBody Statistic stat){
        return statisticService.create(stat);
    }




}
