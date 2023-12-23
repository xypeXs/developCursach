package ru.rsatu.cursach.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import ru.rsatu.cursach.data.dto.delivery.DeliveryCreateRequestDto;
import ru.rsatu.cursach.data.dto.delivery.DeliveryResponseDto;
import ru.rsatu.cursach.data.validation.group.ValidationGroup;
import ru.rsatu.cursach.service.controller.DeliveryControllerService;

@Path("/delivery")
public class DeliveryController {

    @Inject
    DeliveryControllerService deliveryControllerService;

    @POST
    @Path("/request/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestDelivery(@RequestBody @Valid @ConvertGroup(to = ValidationGroup.Post.class) DeliveryCreateRequestDto createRequestDto) {
        DeliveryResponseDto responseDto = deliveryControllerService.createDeliveryRequest(createRequestDto);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDelivery(@QueryParam("uuid") String uuid) {
        DeliveryResponseDto responseDto = deliveryControllerService.getDelivery(uuid);
        return Response.ok(responseDto).build();
    }
}
