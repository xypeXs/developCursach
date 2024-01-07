package ru.rsatu.supplier.service.client.trade;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import ru.rsatu.supplier.data.client.RestClientConfig;
import ru.rsatu.supplier.dto.storage.StorageResponseDto;
import ru.rsatu.supplier.utils.RestClientAuthContext;

@Path("/storage")
@RegisterRestClient(configKey = RestClientConfig.Key.TRADE_SERVICE_API_KEY)
@RegisterProvider(TradeBearerAuthFilter.class)
public interface StorageRestClient {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    StorageResponseDto getStorageInfo(@PathParam("id") Long storageId);

    @ClientExceptionMapper
    default void proceedException(Response response) {
        if (response.getStatus() != HttpStatus.SC_UNAUTHORIZED)
            return;
        RestClientAuthContext.resetToken();
    }

}
