package com.codominator.productservice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.hamcrest.Matchers;

import org.springframework.context.annotation.Import;
import org.testcontainers.mongodb.MongoDBContainer;


import java.math.BigDecimal;


@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new  MongoDBContainer("mongo:7.0.5");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static{
        mongoDBContainer.start();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void shouldCreateProduct() {

        String body = """
            {
                "name": "Iphone 18pro",
                "description": "world's best Iphone",
                "price": 18000
            }
            """;

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/v1/product/create")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("Iphone 18pro"))
                .body("description", Matchers.equalTo("world's best Iphone"))
                .body("price", Matchers.comparesEqualTo(new BigDecimal(18000)));
    }

}
