package com.shawver.camping.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shawver.camping.entity.Category;

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

// any URI that contains "/category" will be mapped to this class
@Validated
@RequestMapping("/category")
@OpenAPIDefinition(info = @Info(title = "Camping Inventory Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })
public interface CategoryController {

	// @formatter:off 
	
	@Operation(
		summary = "Creates a new category",
		description = "Creates a new category",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A new category is returned.", 
				content = @Content(
					mediaType = "application/json", 
					schema = @Schema(implementation = Category.class))),	
			@ApiResponse(
				responseCode = "400",
				description = "The request parameters are invalid.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "404", 
				description = "No category could be created with the input criteria.", 
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
				name = "category",
				allowEmptyValue = false, 
				required = false, 
				description = "The category (i.e. COOKING) the item is designed for.")
		}	
	)
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.OK)		
	String createCategory(
		@RequestParam(required = false) 
			String category);
}
