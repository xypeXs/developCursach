package ru.rsatu.cursach.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import ru.rsatu.cursach.data.dto.good.GoodCreateRequestDto;
import ru.rsatu.cursach.data.dto.good.GoodResponseDto;
import ru.rsatu.cursach.data.dto.good.GoodUpdateRequestDto;
import ru.rsatu.cursach.data.dto.storage.StorageCreateRequestDto;
import ru.rsatu.cursach.data.dto.storage.StorageResponseDto;
import ru.rsatu.cursach.data.dto.storage.StorageUpdateRequestDto;
import ru.rsatu.cursach.service.controller.GoodControllerService;
import ru.rsatu.cursach.service.controller.StorageControllerService;

@Path("/good")
public class GoodController {

    @Inject
    GoodControllerService goodControllerService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGood(@RequestBody @Valid GoodCreateRequestDto createRequestDto) {
        GoodResponseDto responseDto = goodControllerService.createGood(createRequestDto);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGoodInfoInfo(@PathParam("id") Long id) {
        GoodResponseDto responseDto = goodControllerService.getGood(id);
        return Response.ok(responseDto).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGoodInfo(@PathParam("id") Long id, @RequestBody @Valid GoodUpdateRequestDto updateRequestDto) {
        GoodResponseDto responseDto = goodControllerService.updateGood(id, updateRequestDto);
        return Response.ok(responseDto).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteGood(@PathParam("id") Long id) {
        goodControllerService.deleteGood(id);
        return Response.ok().build();
    }

}
