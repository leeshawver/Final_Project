package com.shawver.camping.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shawver.camping.entity.Condition;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author leeshawver
 *
 */
//any URI that contains "/category" will be mapped to this class
@Validated
@RequestMapping("/condition")
@OpenAPIDefinition(info = @Info(title = "Camping Inventory Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })
public interface ConditionController {
	// @formatter:off 
	
	@Operation(
		summary = "Creates a new condition",
		description = "Creates a new condition",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A new condition is returned.", 
				content = @Content(
					mediaType = "application/json", 
					schema = @Schema(implementation = Condition.class))),	
			@ApiResponse(
				responseCode = "400",
				description = "The request parameters are invalid.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "404", 
				description = "No condition could be created with the input criteria.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occurred.", 
				content = @Content(
					mediaType = "application/json"))
		},
		parameters = {
			@Parameter(
				name = "condition",
				allowEmptyValue = false, 
				required = false, 
				description = "The condition (i.e. USED) of the item.")
		}	
	)
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.OK)		
	String createCondition(
		@RequestParam(required = false) 
			String condition);
}
