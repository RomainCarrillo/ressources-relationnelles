package com.cesi.ressourcesrelationnelles.features.statistics;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api")
public class StatisticController {

    @Autowired
    private StatisticRepository statisticRepository;

    @GetMapping("/statistic")
    @CrossOrigin("*")
    public ResponseEntity<Statistic> getStatistic(@RequestParam String id) {
        Optional<Statistic> statistic;
        if(id != null){
            statistic = statisticRepository.findById(id);
            if (statistic.isPresent()) {
                return new ResponseEntity<>(statistic.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/statistics")
    @CrossOrigin("*")
    public ResponseEntity<List<Statistic>> getStatistics(@RequestParam(required = false) String id) {
        if(id != null){
            List<Statistic> statisticList = statisticRepository.findStatisticsByResource(id);
            if(!statisticList.isEmpty())
                return new ResponseEntity<>(statisticList, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // If no argument, get every statistics
        else return new ResponseEntity<>(statisticRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createStatistic")
    @CrossOrigin("*")
    public ResponseEntity<Statistic> createStatistic(@RequestBody Statistic statistic) {
        try {
            Statistic _statistic = statisticRepository.save(statistic);
            return new ResponseEntity<>(_statistic, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteStatistic")
    @CrossOrigin("*")
    public ResponseEntity<HttpStatus> deleteStatistic(@RequestParam String id) {
        try {
            statisticRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
