package io.famargon.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 * HealthCheckEndpoint
 */
@Health
public class HealthCheckEndpoint implements HealthCheck {

    @ConfigProperty(name = "service.name", defaultValue = "unknown")
    String serviceName;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.builder()
            .up()
            .name(serviceName)
            .build();
    }

}