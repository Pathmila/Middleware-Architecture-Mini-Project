package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.allOf;

@QuarkusTest
public class PetResourceTest {

	@Test
    public void testPetEndpoint() {
        given()
          .when().get("/v1/pets")
          .then()
             .statusCode(200);           
    }
	
	@Test
    public void testDeletePetEndpoint() {
        given()
          .when().delete("v1/pets/deletePet/1")
          .then()
             .statusCode(200);           
    }
	
//	@Test
//	public void testAddPetEndpoint() {
//	    given()
//	      .when().post("v1/pets/addPet")
//	      .then()
//	         .statusCode(200);           
//	}
	
//	@Test
//  public void testUpdateTypeEndpoint() {
//      given()
//        .when().put("v1/pets/updatePet/1")
//        .then()
//           .statusCode(200);           
//  }
	
	@Test
    public void testPetByIdEndpoint() {
        given()
          .when().get("v1/pets/id/1")
          .then()
             .statusCode(200);           
    }
	
	@Test
    public void testPetByNameEndpoint() {
        given()
          .when().get("v1/pets/name/Sudda")
          .then()
             .statusCode(200);           
    }
	
	@Test
    public void testPetByTypeEndpoint() {
        given()
          .when().get("v1/pets/type/Bird")
          .then()
             .statusCode(200);           
    }
	
}