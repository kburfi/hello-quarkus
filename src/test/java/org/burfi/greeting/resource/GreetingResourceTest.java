package org.burfi.greeting.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
class GreetingResourceTest {

    @Test
    public void testGreetingEndpoint() {
        given()
                .when().get("/greetings")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    // todo - write tests
//    @Test
//    public void testAdd() {
//        given()
//                .body("{\"name\": \"greeting test\", \"timestamp\": \"2021-10-17T17:07:12.001Z\"}")
//                .header("Content-Type", MediaType.APPLICATION_JSON)
//                .when()
//                .post("/greetings")
//                .then()
//                .statusCode(200)
//                .body(notNullValue(),
//                        "name", containsInAnyOrder("Apple", "Pineapple", "Pear"),
//                        "description", containsInAnyOrder("Winter fruit", "Tropical fruit", "Winter fruit"));
//    }
}