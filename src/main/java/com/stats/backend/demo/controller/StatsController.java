package com.stats.backend.demo.controller;

import com.stats.backend.demo.model.Stats;
import com.stats.backend.demo.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/collect")
    public ResponseEntity<Stats> collectStats() {
        Stats stats = statsService.collectStats();
        return ResponseEntity.ok(stats);
    }
}
