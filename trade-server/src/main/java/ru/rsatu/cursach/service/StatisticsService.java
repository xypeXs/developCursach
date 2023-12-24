package ru.rsatu.cursach.service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.data.template.Statistics;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class StatisticsService {
    private LocalDateTime startTime;

    @PostConstruct
    public void init() {
        startTime = LocalDateTime.now();
    }

    public Statistics getApplicationStatistics() {
        Statistics statistics = new Statistics();
        statistics.setRuntimeMillis(ChronoUnit.MILLIS.between(startTime, LocalDateTime.now()));
        return statistics;
    }
}
