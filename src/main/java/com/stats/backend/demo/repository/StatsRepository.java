package com.stats.backend.demo.repository;

import com.stats.backend.demo.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface StatsRepository extends JpaRepository<Stats, LocalDateTime> {
}