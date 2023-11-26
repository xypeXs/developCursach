package ru.rsatu.cursach.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.cursach.service.controller.ReferenceControllerService;

@Path("/reference")
public class ReferenceController {

    @Inject
    ReferenceControllerService referenceControllerService;

    @GET
    @Path("/good-type/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@PathParam("id") String encryptedId) {
        return Response
                .ok(referenceControllerService.getGoodType(encryptedId))
                .build();
    }
}
