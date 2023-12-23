package ru.rsatu.cursach.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.cursach.service.StatisticsService;

@Path("/front")
public class FrontController {

    @Inject
    StatisticsService statisticsService;

    @GET
    @Path("/statistics")
    public Response getApplicationStatisticsHTMLPage() {

        return createHTMLPageResponse()
    }

    public Response createHTMLPageResponse(Object object) {
        return Response
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML)
                .build();
    }
}
