package ru.rsatu.cursach.service;

import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import ru.rsatu.cursach.data.template.Statistics;

@Singleton
public class TemplateRendererService {

    @Inject
    StatisticsService statisticsService;

    @Location("html/statistics")
    Template statisticsTemplate;

    public String renderStatisticsHTML() {
        Statistics statistics = statisticsService.getApplicationStatistics();
        return statisticsTemplate.data(statistics).render();
    }
}
