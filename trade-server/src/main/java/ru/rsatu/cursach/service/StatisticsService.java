package ru.rsatu.cursach.service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class StatisticsService {
    private LocalDateTime startTime;

    @PostConstruct
    public void init() {
        startTime = LocalDateTime.now();
    }

    public long getApplicationActiveTime() {
        return ChronoUnit.MILLIS.between(LocalDateTime.now(), startTime);
    }
}
