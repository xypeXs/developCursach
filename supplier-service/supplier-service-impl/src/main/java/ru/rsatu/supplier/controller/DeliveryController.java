package ru.rsatu.supplier.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.supplier.service.controller.DeliveryControllerService;
import ru.rsatu.supplier.dto.delivery.DeliveryResponseDto;

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
