package com.cesi.ressourcesrelationnelles.features.statistics;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StatisticsController {
    @GetMapping("/statistics")
    public ArrayList<Statistic> getALlStatistics() {
        ArrayList<Statistic> listStats = new ArrayList<>();
        listStats.add(new Statistic(1, 1, 10));
        listStats.add(new Statistic(2, 2, 100));
        listStats.add(new Statistic(10, 15, 1000));
        return listStats;
    }
}
