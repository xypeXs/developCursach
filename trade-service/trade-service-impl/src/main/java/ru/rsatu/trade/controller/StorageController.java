package ru.rsatu.trade.controller;

import jakarta.annotation.security.RolesAllowed;
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
import ru.rsatu.trade.data.dto.storage.StorageCreateRequestDto;
import ru.rsatu.trade.data.dto.storage.StorageGoodResponseDto;
import ru.rsatu.trade.data.dto.storage.StorageResponseDto;
import ru.rsatu.trade.data.dto.storage.StorageUpdateRequestDto;
import ru.rsatu.trade.service.controller.StorageControllerService;
import ru.rsatu.trade.utils.SecurityUtils;

import java.util.List;

@Path("/storage")
public class StorageController {

    @Inject
    StorageControllerService storageControllerService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.CREATE_STORAGE })
    public Response createStorage(@RequestBody @Valid StorageCreateRequestDto createRequestDto) {
        StorageResponseDto responseDto = storageControllerService.createStorage(createRequestDto);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.READ_STORAGE })
    public Response getStorageInfo(@PathParam("id") Long id) {
        StorageResponseDto responseDto = storageControllerService.getStorageInfo(id);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/{id}/goods/list")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.READ_GOOD })
    public Response getStorageGoodList(@PathParam("id") Long id) {
        List<StorageGoodResponseDto> responseDtoList = storageControllerService.getStorageGoodList(id);
        return Response.ok(responseDtoList).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.UPDATE_STORAGE })
    public Response updateStorageInfo(@PathParam("id") Long id, @RequestBody @Valid StorageUpdateRequestDto updateRequestDto) {
        StorageResponseDto responseDto = storageControllerService.updateStorage(id, updateRequestDto);
        return Response.ok(responseDto).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.DELETE_STORAGE })
    public Response deleteStorage(@PathParam("id") Long id) {
        storageControllerService.deleteStorage(id);
        return Response.ok().build();
    }

}
