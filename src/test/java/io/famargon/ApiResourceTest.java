package io.famargon;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTestResource(H2DatabaseTestResource.class)
@QuarkusTest
public class ApiResourceTest {

    @ConfigProperty(name = "deployment.environment")
    String env;

    @Test
    public void testHelloEndpoint() {
        // RestAssured.given()
        //   .when().get("/api/env")
        //   .then()
        //      .statusCode(200)
        //      .body(is(env));
    }

}