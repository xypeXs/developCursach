package ru.rsatu.trade.service;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Singleton;
import ru.rsatu.trade.data.template.Statistics;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Singleton
public class StatisticsService {
    private LocalDateTime startTime;

    void onStart(@Observes StartupEvent ev) {
        startTime = LocalDateTime.now();
    }

    public Statistics getApplicationStatistics() {
        Statistics statistics = new Statistics();
        statistics.setRuntimeMillis(ChronoUnit.MILLIS.between(startTime, LocalDateTime.now()));
        return statistics;
    }
}
