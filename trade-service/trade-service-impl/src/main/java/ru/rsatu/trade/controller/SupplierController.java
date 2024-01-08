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
import ru.rsatu.trade.data.dto.supplier.SupplierCreateRequestDto;
import ru.rsatu.trade.data.dto.supplier.SupplierResponseDto;
import ru.rsatu.trade.data.dto.supplier.SupplierUpdateRequestDto;
import ru.rsatu.trade.service.controller.SupplierControllerService;
import ru.rsatu.trade.utils.SecurityUtils;

@Path("/supplier")
public class SupplierController {

    @Inject
    SupplierControllerService supplierControllerService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.CREATE_SUPPLIER })
    public Response createSupplier(@RequestBody @Valid SupplierCreateRequestDto createRequestDto) {
        SupplierResponseDto responseDto = supplierControllerService.createSupplier(createRequestDto);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.READ_SUPPLIER })
    public Response getSupplier(@PathParam("id") Long id) {
        SupplierResponseDto responseDto = supplierControllerService.getSupplier(id);
        return Response.ok(responseDto).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.UPDATE_SUPPLIER })
    public Response updateSupplier(@PathParam("id") Long id, @RequestBody @Valid SupplierUpdateRequestDto updateRequestDto) {
        SupplierResponseDto responseDto = supplierControllerService.updateSupplier(id, updateRequestDto);
        return Response.ok(responseDto).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.DELETE_SUPPLIER })
    public Response deleteSupplier(@PathParam("id") Long id) {
        supplierControllerService.deleteSupplier(id);
        return Response.ok().build();
    }
}
