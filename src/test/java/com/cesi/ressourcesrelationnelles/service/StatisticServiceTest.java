package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StatisticServiceTest {

    @Autowired
    private StatisticService statisticService;

    @Test
    void createStatisticTest(){
        Statistic statistic = new Statistic(1,1,10);
        statisticService.create(statistic);
        List<Statistic> actualStatistics = statisticService.liste();
        assertNotNull(actualStatistics);
        assertEquals(1, actualStatistics.size());


    }
}
