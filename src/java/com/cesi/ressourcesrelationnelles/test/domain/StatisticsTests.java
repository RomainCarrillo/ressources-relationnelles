package java.com.cesi.ressourcesrelationnelles.test.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.cesi.ressourcesrelationnelles.domain.Statistic;

public class StatisticsTests {
    @Test
    public void createStatistic() {
        Statistic stat = new Statistic(1, 1, 200);
        assertNotNull(stat);
        stat.setId(1);
        assertEquals(1, stat.getId());
    }

    @Test
    public void getNbVues() {
        Statistic stat = new Statistic(1, 1, 10);
        assertNotNull(stat);
        stat.setId(1);
        stat.setNbVues(2000);
        assertEquals(2000, stat.getNbVues());
    }
}
