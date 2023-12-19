package ru.rsatu.cursach.controller;

import jakarta.inject.Inject;
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
import ru.rsatu.cursach.data.dto.storage.StorageCreateRequestDto;
import ru.rsatu.cursach.data.dto.storage.StorageGoodResponseDto;
import ru.rsatu.cursach.data.dto.storage.StorageResponseDto;
import ru.rsatu.cursach.data.dto.storage.StorageUpdateRequestDto;
import ru.rsatu.cursach.service.controller.StorageControllerService;

import java.util.List;

@Path("/storage")
public class StorageController {

    @Inject
    StorageControllerService storageControllerService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStorage(@RequestBody StorageCreateRequestDto createRequestDto) {
        StorageResponseDto responseDto = storageControllerService.createStorage(createRequestDto);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStorageInfo(@PathParam("id") Long id) {
        StorageResponseDto responseDto = storageControllerService.getStorageInfo(id);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/{id}/goods/list")
    public Response getStorageGoodList(@PathParam("id") Long id) {
        List<StorageGoodResponseDto> responseDtoList = storageControllerService.getStorageGoodList(id);
        return Response.ok(responseDtoList).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStorageInfo(@PathParam("id") Long id, @RequestBody StorageUpdateRequestDto updateRequestDto) {
        StorageResponseDto responseDto = storageControllerService.updateStorage(id, updateRequestDto);
        return Response.ok(responseDto).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStorage(@PathParam("id") Long id) {
        storageControllerService.deleteStorage(id);
        return Response.ok().build();
    }

}
