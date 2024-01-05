package ru.rsatu.cursach.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.cursach.data.dto.DeliveryResponseDto;
import ru.rsatu.cursach.service.controller.DeliveryControllerService;

@Path("/delivery")
public class DeliveryController {

    @Inject
    DeliveryControllerService deliveryControllerService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDelivery(@QueryParam("uuid") String uuid) {
        DeliveryResponseDto responseDto = deliveryControllerService.getDelivery(uuid);
        return Response.ok(responseDto).build();
    }
}
