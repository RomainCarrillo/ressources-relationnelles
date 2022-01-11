package com.cesi.ressourcesrelationnelles.controller;

import org.junit.jupiter.api.Test;
import com.cesi.ressourcesrelationnelles.features.statistics.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StatisticsTests {
    @Test
    public void createStatistic() {
        Statistics stat = new Statistics();
        assertNotNull(stat);
        stat.setId(1);
        assertEquals(1, stat.getId());
    }

    @Test
    public void getNbVues() {
        Statistics stat = new Statistics();
        assertNotNull(stat);
        stat.setId(1);
        stat.setNbVues(2000);
        assertEquals(2000, stat.getNbVues());
    }
}
