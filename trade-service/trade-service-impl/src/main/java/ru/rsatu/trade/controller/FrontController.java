package ru.rsatu.trade.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.trade.service.TemplateRendererService;
import ru.rsatu.trade.utils.SecurityUtils;

@Path("/front")
public class FrontController {

    @Inject
    TemplateRendererService templateRendererService;

    @GET
    @Path("/statistics")
    @RolesAllowed(value = { SecurityUtils.Role.READ_APP_STATISTICS })
    public Response getApplicationStatisticsHTMLPage() {
        String statisticsTemplate = templateRendererService.renderStatisticsHTML();
        return createHTMLPageResponse(statisticsTemplate);
    }

    public Response createHTMLPageResponse(Object object) {
        return Response
                .ok(object)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML)
                .build();
    }
}
