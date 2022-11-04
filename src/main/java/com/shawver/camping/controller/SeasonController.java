package com.shawver.camping.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shawver.camping.entity.SeasonResult;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author leeshawver
 *
 */

@Validated
@RequestMapping("/season")
@OpenAPIDefinition(info = @Info(title = "Camping Inventory Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })
public interface SeasonController {
	// @formatter:off 
	
	@Operation(
		summary = "Returns a list of season",
		description = "Returns a list of all seasons",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of seasons is returned.", 
				content = @Content(
					mediaType = "application/json", 
					schema = @Schema(implementation = SeasonResult.class))),	
			@ApiResponse(
				responseCode = "400",
				description = "The request parameters are invalid.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "404", 
				description = "No seasons could be returned with the input criteria.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occurred.", 
				content = @Content(
					mediaType = "application/json"))
		}	
	)
	
	@GetMapping("/all")
	@ResponseStatus(code = HttpStatus.OK)		
	List<SeasonResult> fetchAllSeasons();
}
