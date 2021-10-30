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


@Path("/v1/types")
@Produces("application/json")
public class TypeResource {

	List<Type> types = new ArrayList<Type>();
	
	public TypeResource() {
		Type type1 = new Type();
		type1.setTypeId(1);
		type1.setPetType("Dog");
		
		Type type2 = new Type();
		type2.setTypeId(2);
		type2.setPetType("Cat");
		
		Type type3 = new Type();
		type3.setTypeId(3);
		type3.setPetType("Bird");
		
		Type type4 = new Type();
		type4.setTypeId(4);
		type4.setPetType("Rabit");
		
		types.add(type1);
		types.add(type2);
		types.add(type3);
		types.add(type4);
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Types", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Type"))) })
	@GET
	public Response getType() {		
		return Response.ok(types).build();
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Add a type", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Type"))),
			@APIResponse(responseCode = "404", description = "Not found.") })
	@POST
	@Path("/addType")	
	public Response newTypeAdd(Type type1) {		

		types.add(type1);
		return Response.ok(types).build();
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Update a type", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Type"))),
			@APIResponse(responseCode = "404", description = "Not found.") })
	@PUT
	@Path("/updateType/{typeId}")	
	public Response PetUpdateById(@PathParam("typeId") int typeId, Type type1) {		

		Type filtertype = types.stream().filter(id -> typeId == id.getTypeId()).findAny().orElse(null);
	
		types.remove(filtertype);
		types.add(type1);
			
		return Response.ok(types).build();
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Delete a type", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Type"))),
			@APIResponse(responseCode = "404", description = "Not found.") })
	@DELETE
	@Path("/deletePet/{typeId}")	
	public Response TypeDeleteById(@PathParam("typeId") int typeId) {		

		Type filtertype = types.stream().filter(id -> typeId == id.getTypeId()).findAny().orElse(null);
	
		types.remove(filtertype);		
			
		return Response.ok(types).build();
	}
	
}
