package ru.rsatu.cursach.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.cursach.data.dto.offer.SupplierOfferResponseDto;
import ru.rsatu.cursach.service.controller.OfferControllerService;

import java.util.List;

@Path("/offer")
public class OfferController {

    @Inject
    OfferControllerService offerControllerService;

    @POST
    @Path("/supplier/{supplierId}/good/{goodId}/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOffer(@PathParam("supplierId") Long supplierId, @PathParam("goodId") Long goodId) {
        SupplierOfferResponseDto responseDto = offerControllerService.createOffer(supplierId, goodId);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/supplier/{supplierId}/good/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierOfferListBySupplier(@PathParam("supplierId") Long supplierId) {
        List<SupplierOfferResponseDto> responseDtoList = offerControllerService.getSupplierOfferListBySupplier(supplierId);
        return Response.ok(responseDtoList).build();
    }

    @GET
    @Path("/good/{goodId}/supplier/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierOfferListByGood(@PathParam("goodId") Long goodId) {
        List<SupplierOfferResponseDto> responseDtoList = offerControllerService.getSupplierOfferListByGood(goodId);
        return Response.ok(responseDtoList).build();
    }

    @DELETE
    @Path("/supplier/{supplierId}/good/{goodId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOffer(@PathParam("supplierId") Long supplierId, @PathParam("goodId") Long goodId) {
        offerControllerService.deleteOffer(supplierId, goodId);
        return Response.ok().build();
    }
}
