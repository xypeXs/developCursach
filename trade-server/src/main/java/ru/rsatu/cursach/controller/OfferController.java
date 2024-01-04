package ru.rsatu.cursach.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import ru.rsatu.cursach.data.dto.offer.SupplierOfferCreateRequestDto;
import ru.rsatu.cursach.data.dto.offer.SupplierOfferResponseDto;
import ru.rsatu.cursach.service.controller.OfferControllerService;
import ru.rsatu.cursach.utils.SecurityUtils;

import java.util.List;

@Path("/offer")
public class OfferController {

    @Inject
    OfferControllerService offerControllerService;

    @POST
    @Path("/supplier/{supplierId}/good/{goodId}/create")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.CREATE_SUPPLIER_OFFER })
    public Response createOffer(@PathParam("supplierId") Long supplierId, @PathParam("goodId") Long goodId,
                                @RequestBody @Valid SupplierOfferCreateRequestDto requestDto) {
        SupplierOfferResponseDto responseDto = offerControllerService.createOffer(supplierId, goodId, requestDto);
        return Response.ok(responseDto).build();
    }

    @GET
    @Path("/supplier/{supplierId}/good/list")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.READ_SUPPLIER_OFFER })
    public Response getSupplierOfferListBySupplier(@PathParam("supplierId") Long supplierId) {
        List<SupplierOfferResponseDto> responseDtoList = offerControllerService.getSupplierOfferListBySupplier(supplierId);
        return Response.ok(responseDtoList).build();
    }

    @GET
    @Path("/good/{goodId}/supplier/list")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.READ_SUPPLIER_OFFER })
    public Response getSupplierOfferListByGood(@PathParam("goodId") Long goodId) {
        List<SupplierOfferResponseDto> responseDtoList = offerControllerService.getSupplierOfferListByGood(goodId);
        return Response.ok(responseDtoList).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(value = { SecurityUtils.Role.DELETE_SUPPLIER_OFFER })
    public Response deleteOffer(@PathParam("id") Long offerId) {
        offerControllerService.deleteOffer(offerId);
        return Response.ok().build();
    }
}
