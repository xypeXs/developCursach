package ru.rsatu.supplier.service.client.trade;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import ru.rsatu.supplier.data.client.RestClientProperty;
import ru.rsatu.trade.data.dto.offer.SupplierOfferResponseDto;

@Path("/offer")
@RegisterRestClient(configKey = RestClientProperty.Key.TRADE_SERVICE_API_KEY)
public interface SupplierOfferRestClient {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    SupplierOfferResponseDto getSupplierOfferInfo(@PathParam("id") Long offerId);

}
