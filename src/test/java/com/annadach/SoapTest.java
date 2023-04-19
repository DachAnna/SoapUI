package com.annadach;

import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

import java.io.InputStream;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SoapTest {

    @Test
    void getCountriesTest() throws Exception{
        InputStream is = SoapTest.class.getClassLoader().getResourceAsStream("getCountryRequest.xml");
        final String request = new String(IOUtils.toByteArray(is));

        RestAssured.baseURI = "http://localhost:8080/ws";

        Response response=given()
                .header("Content-Type", "text/xml")
                .and()
                .body(request)
                .when()
                .post("/getCountry")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());
        assertTrue(response.asString().contains("Madrid"));
    }
}
