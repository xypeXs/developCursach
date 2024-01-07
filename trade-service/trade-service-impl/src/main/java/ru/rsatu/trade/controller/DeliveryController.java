package ru.rsatu.trade.controller;

import jakarta.annotation.security.RolesAllowed;
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
import ru.rsatu.trade.data.dto.delivery.DeliveryCreateRequestDto;
import ru.rsatu.trade.data.dto.delivery.DeliveryResponseDto;
import ru.rsatu.trade.data.validation.group.ValidationGroup;
import ru.rsatu.trade.service.controller.DeliveryControllerService;
import ru.rsatu.trade.utils.SecurityUtils;

@Path("/delivery")
public class DeliveryController {

    @Inject
    DeliveryControllerService deliveryControllerService;

    @POST
    @Path("/request/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.CREATE_DELIVERY })
    public Response requestDelivery(@RequestBody @Valid @ConvertGroup(to = ValidationGroup.Post.class) DeliveryCreateRequestDto createRequestDto) {
        DeliveryResponseDto responseDto = deliveryControllerService.createDeliveryRequest(createRequestDto);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.READ_DELIVERY })
    public Response getDelivery(@QueryParam("uuid") String uuid) {
        DeliveryResponseDto responseDto = deliveryControllerService.getDelivery(uuid);
        return Response.ok(responseDto).build();
    }
}
