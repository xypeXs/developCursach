package ru.rsatu.cursach.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.cursach.service.controller.ReferenceControllerService;

@Path("/reference")
public class ReferenceController {

    @Inject
    ReferenceControllerService referenceControllerService;

    @GET
    @Path("/delivery-status/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryStatusByCode(@PathParam("code") String code) {
        return Response
                .ok(referenceControllerService.getDeliveryStatus(code))
                .build();
    }

    @GET
    @Path("/delivery-status/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryStatusList(@QueryParam("index") Integer index, @QueryParam("size") Integer size) {
        return Response
                .ok(referenceControllerService.getDeliveryStatusList(index, size))
                .build();
    }
}
