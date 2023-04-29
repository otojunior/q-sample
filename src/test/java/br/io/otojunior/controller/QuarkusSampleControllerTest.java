package br.io.otojunior.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class QuarkusSampleControllerTest {

	@Test
	public void testHelloEndpoint() {
		given()
			.header("x-teste", "teste123")
			.log().all(true)
			.get("/hello")
			.then()
			.statusCode(200)
			.body(is("teste123"));
	}
}