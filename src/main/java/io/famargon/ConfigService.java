package io.famargon;

import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * ConfigService
 */
@Singleton
public class ConfigService {

    @ConfigProperty(name = "deployment.environment", defaultValue = "unknown")
    String deploymentEnvironment;
    
    public String getDeploymentEnvironment() {
        return this.deploymentEnvironment;
    }

}