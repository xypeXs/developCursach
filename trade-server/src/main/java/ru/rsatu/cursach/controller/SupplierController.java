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
import ru.rsatu.cursach.data.dto.supplier.SupplierCreateRequestDto;
import ru.rsatu.cursach.data.dto.supplier.SupplierResponseDto;
import ru.rsatu.cursach.data.dto.supplier.SupplierUpdateRequestDto;
import ru.rsatu.cursach.service.controller.SupplierControllerService;

@Path("/supplier")
public class SupplierController {

    @Inject
    SupplierControllerService supplierControllerService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGood(@RequestBody SupplierCreateRequestDto createRequestDto) {
        SupplierResponseDto responseDto = supplierControllerService.createSupplier(createRequestDto);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGoodInfoInfo(@PathParam("id") Long id) {
        SupplierResponseDto responseDto = supplierControllerService.getSupplier(id);
        return Response.ok(responseDto).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGoodInfo(@PathParam("id") Long id, @RequestBody SupplierUpdateRequestDto updateRequestDto) {
        SupplierResponseDto responseDto = supplierControllerService.updateSupplier(id, updateRequestDto);
        return Response.ok(responseDto).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteGood(@PathParam("id") Long id) {
        supplierControllerService.deleteSupplier(id);
        return Response.ok().build();
    }
}
