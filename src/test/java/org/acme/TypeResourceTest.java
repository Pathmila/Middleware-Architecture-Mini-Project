package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.allOf;

@QuarkusTest
public class TypeResourceTest {
	
	@Test
    public void testAllTypesEndpoint() {
        given()
          .when().get("v1/types")
          .then()
             .statusCode(200);           
    }
	
	@Test
    public void testDeleteTypeEndpoint() {
        given()
          .when().delete("v1/types/deletePet/5")
          .then()
             .statusCode(200);           
    }
	
//	@Test
//    public void testAddypeEndpoint() {
//        given()
//          .when().get("v1/types/addType")
//          .then()
//             .statusCode(200);           
//    }
	
	
//	@Test
//    public void testUpdateTypeEndpoint() {
//        given()
//          .when().put("v1/types/updateType/5")
//          .then()
//             .statusCode(200);           
//    }
	
}
