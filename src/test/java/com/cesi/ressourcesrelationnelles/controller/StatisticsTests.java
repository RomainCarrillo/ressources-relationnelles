package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.util.Assert;
import com.cesi.ressourcesrelationnelles.*;
import org.junit.jupiter.api.Test;
import com.cesi.ressourcesrelationnelles.features.statistics.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StatisticsTests {
    @Test
    public void createStatistic() {
        StatisticsClass stat = new StatisticsClass();
        assertNotNull(stat);
        stat.setId(1);
        assertEquals(1, stat.getId());
    }

    @Test
    public void getNbVues() {
        StatisticsClass stat = new StatisticsClass();
        assertNotNull(stat);
        stat.setId(1);
        stat.setNbVues(2000);
        assertEquals(2000, stat.getNbVues());
    }
}
