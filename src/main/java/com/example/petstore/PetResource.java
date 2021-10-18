package com.example.petstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/pets")
@Produces("application/json")
public class PetResource {
	
	List<Pet> pets = new ArrayList<Pet>();
				
	public PetResource() {
		Pet pet1 = new Pet();
		pet1.setPetId(1);
		pet1.setPetAge(3);
		pet1.setPetName("Boola");
		pet1.setPetType("Dog");

		Pet pet2 = new Pet();
		pet2.setPetId(2);
		pet2.setPetAge(4);
		pet2.setPetName("Sudda");
		pet2.setPetType("Cat");

		Pet pet3 = new Pet();
		pet3.setPetId(3);
		pet3.setPetAge(2);
		pet3.setPetName("Peththappu");
		pet3.setPetType("Bird");

		pets.add(pet1);
		pets.add(pet2);
		pets.add(pet3);
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	public Response getPets() {		
		return Response.ok(pets).build();
	}
	
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@GET
	@Path("/id/{petId}")
	public Response getPet(@PathParam("petId") int petId) {		
		
		Pet filterpets = pets.stream().filter(id -> petId == id.getPetId()).findAny().orElse(null);

		return Response.ok(filterpets).build();

	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for name", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the name.") })
	@GET
	@Path("/name/{petName}")		
	public Response getPetByName(@PathParam("petName") String petName) {
		
		Pet filterpets = pets.stream().filter(name -> petName.equals(name.getPetName())).findAny().orElse(null);
		
		return Response.ok(filterpets).build();
	
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for type", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the type.") })
	@GET
	@Path("/type/{petType}")		
	public Response getPetByType(@PathParam("petType") String petType) {
		
		Pet filterpets = pets.stream().filter(type -> petType.equals(type.getPetType())).findAny().orElse(null);
	
		return Response.ok(filterpets).build();
	
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for age", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the age.") })
	@GET
	@Path("/age/{petAge}")
	public Response getPetByAge(@PathParam("petAge") int petAge) {			
		
		Pet filterpets = pets.stream().filter(age -> petAge == age.getPetAge()).findAny().orElse(null);
	
		return Response.ok(filterpets).build();

	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "IDs of pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No IDs are found.") })
	@GET
	@Path("/getIds")
	public Response getPetIds() {				
		
		List<Integer> list = pets.stream().map(t->t.getPetId()).collect(Collectors.toList());
	
		return Response.ok(list).build();

	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Names of pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No names are found.") })
	@GET
	@Path("/getNames")
	public Response getPetNames() {				
		
		List<String> list = pets.stream().map(t->t.getPetName()).collect(Collectors.toList());
	
		return Response.ok(list).build();

	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Types of pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No types are found.") })
	@GET
	@Path("/getTypes")
	public Response getPetTypes() {				
		
		List<String> list = pets.stream().map(t->t.getPetType()).collect(Collectors.toList());
	
		return Response.ok(list).build();

	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Add a pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "Not found.") })
	@POST
	@Path("/addPet")	
	public Response newPetAdd(Pet pet1) {		

		pets.add(pet1);
		return Response.ok(pets).build();
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Update a pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "Not found.") })
	@PUT
	@Path("/updatePet/{petId}")	
	public Response PetUpdateById(@PathParam("petId") int petId, Pet pet1) {		

		Pet filterpets = pets.stream().filter(id -> petId == id.getPetId()).findAny().orElse(null);
	
		pets.remove(filterpets);
		pets.add(pet1);
			
		return Response.ok(pets).build();
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Delete a pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "Not found.") })
	@DELETE
	@Path("/deletePet/{petId}")	
	public Response PetDeleteById(@PathParam("petId") int petId) {		

		Pet filterpets = pets.stream().filter(id -> petId == id.getPetId()).findAny().orElse(null);
	
		pets.remove(filterpets);		
			
		return Response.ok(pets).build();
	}
	
}



