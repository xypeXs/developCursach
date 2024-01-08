package ru.rsatu.supplier.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.annotation.RegisterProviders;
import ru.rsatu.supplier.service.client.trade.TradeBearerAuthFilter;

@ApplicationScoped
@RegisterProviders({
    @RegisterProvider(TradeBearerAuthFilter.class)
})
public class RestClientConfig {
}
