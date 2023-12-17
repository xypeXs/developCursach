package ru.rsatu.cursach.controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import ru.rsatu.cursach.data.dto.delivery.DeliveryCreateRequestDto;

@Path("/delivery")
public class DeliveryController {
    @POST
    @Path("/request/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestDelivery(@RequestBody DeliveryCreateRequestDto createRequestDto) {

    }
}
