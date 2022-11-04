package com.shawver.camping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shawver.camping.entity.Category;
import com.shawver.camping.entity.Condition;
import com.shawver.camping.entity.Item;
import com.shawver.camping.entity.Season;

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

// any URI that contains "/items" will be mapped to this class
@Validated
@RequestMapping("/items")
@OpenAPIDefinition(info = @Info(title = "Camping Inventory Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })
public interface ItemController {

	// @formatter:off 
	
	@Operation(
		summary = "Returns a list of items",
		description = "Returns a list of items given a season",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of items is returned.", 
				content = @Content(
					mediaType = "application/json", 
					schema = @Schema(implementation = Item.class))),	
			@ApiResponse(
				responseCode = "400",
				description = "The request parametesr are invalid.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "404", 
				description = "No items were found with the input criteria.", 
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
				name = "season",
				allowEmptyValue = false, 
				required = false, 
				description = "The season (i.e. Winter) the item is designed for.")
		}	
	)
	
	
	//if no params above, no need for @RequestParam below
	@GetMapping("/season")
	@ResponseStatus(code = HttpStatus.OK)		
	List<Item> fetchItemsBySeason(
		@RequestParam(required = false) 
			Season season);
	
	@Operation(
		summary = "Returns a list of items",
		description = "Returns a list of items given a condition",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of items is returned.", 
				content = @Content(
					mediaType = "application/json", 
					schema = @Schema(implementation = Item.class))),	
			@ApiResponse(
				responseCode = "400",
				description = "The request parametesr are invalid.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "404", 
				description = "No items were found with the input criteria.", 
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
				description = "The condition of the item.")
		}	
	)
	
	@GetMapping("/condition")
	@ResponseStatus(code = HttpStatus.OK)		
	List<Item> fetchItemsByCondition(
		@RequestParam(required = false) 
			Condition condition);
	
	@Operation(
		summary = "Returns a list of items",
		description = "Returns a list of items given a category",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of items is returned.", 
				content = @Content(
					mediaType = "application/json", 
					schema = @Schema(implementation = Item.class))),	
			@ApiResponse(
				responseCode = "400",
				description = "The request parametesr are invalid.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "404", 
				description = "No items were found with the input criteria.", 
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
				description = "The category the item is designed for.")
		}	
	)
	
	@GetMapping("/category")
	@ResponseStatus(code = HttpStatus.OK)		
	List<Item> fetchItemsByCategory(
		@RequestParam(required = false) 
			Category category);
	
	@Operation(
		summary = "Returns a list of items",
		description = "Returns a list of all items",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of items is returned.", 
				content = @Content(
					mediaType = "application/json", 
					schema = @Schema(implementation = Item.class))),	
			@ApiResponse(
				responseCode = "400",
				description = "The request parametesr are invalid.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "404", 
				description = "No items were found with the input criteria.", 
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
	List<Item> fetchAllItems();	
	
	@Operation(
		summary = "Creates a new item",
		description = "Inserts a new item in inventory with Season, Condition, and Category",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A new item is created.", 
				content = @Content(
					mediaType = "application/json", 
					schema = @Schema(implementation = Item.class))),	
			@ApiResponse(
				responseCode = "400",
				description = "The request parametesr are invalid.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "404", 
				description = "No item could be created with the input criteria.", 
				content = @Content(
					mediaType = "application/json")),	
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occurred.", 
				content = @Content(
					mediaType = "application/json"))
		}
//		,
//		parameters = {
//				@Parameter(
//					name = "category",
//					allowEmptyValue = false, 
//					required = false, 
//					description = "The category (i.e. Sleep system) the item is designed for.")
//			}
		
	)

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<Item> createItem(
		@RequestParam(required = false) 
		String itemId,
		@RequestParam(required = false) 
		String itemName, 
		@RequestParam(required = false)
		String itemManufacturer,
		@RequestParam(required = false) 
		Season season,
		@RequestParam(required = false) 
		Condition condition,
		@RequestParam(required = false) 
		Category category);
	
	@Operation(
			summary = "Updates an item",
			description = "Modifies the name of an existing item given an ID and existing name.",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "An item is updated.", 
					content = @Content(
						mediaType = "application/json", 
						schema = @Schema(implementation = Item.class))),	
				@ApiResponse(
					responseCode = "400",
					description = "The request parametesr are invalid.", 
					content = @Content(
						mediaType = "application/json")),	
				@ApiResponse(
					responseCode = "404", 
					description = "No item could be updated with the input criteria.", 
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
					name = "itemId",
					allowEmptyValue = false, 
					required = false, 
					description = "Enter item ID."),
				@Parameter(
					name = "itemName",
					allowEmptyValue = false, 
					required = false, 
					description = "Enter existing item name."),
				@Parameter(
					name = "newManufacturer",
					allowEmptyValue = false, 
					required = false, 
					description = "Enter a new item manufacturer."),
				@Parameter(
					name = "newName",
					allowEmptyValue = false, 
					required = false, 
					description = "Enter a new item name."),
				@Parameter(
					name = "newSeason",
					allowEmptyValue = false, 
					required = false, 
					description = "Select a new item season."),
				@Parameter(
					name = "newCondition",
					allowEmptyValue = false, 
					required = false, 
					description = "Selecct a new item condition."),
				@Parameter(
					name = "newCategory",
					allowEmptyValue = false, 
					required = false, 
					description = "Select a new item category."),
				}
		)
	// consider list of enum(season)
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<Item> updateItem(
		@RequestParam(required = false) 
		String itemId,
		@RequestParam(required = false) 
		String itemName, 
		@RequestParam(required = false) 
		String newManufacturer,
		@RequestParam(required = false) 
		String newName,
		@RequestParam(required = false) 
		Season newSeason,
		@RequestParam(required = false) 
		Condition newCondition,
		@RequestParam(required = false) 
		Category newCategory);	
	;
	
	@Operation(
			summary = "Deletes an item",
			description = "Deletes an existing item",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "An item is deleted.", 
					content = @Content(
						mediaType = "application/json", 
						schema = @Schema(implementation = Item.class))),	
				@ApiResponse(
					responseCode = "400",
					description = "The request parametesr are invalid.", 
					content = @Content(
						mediaType = "application/json")),	
				@ApiResponse(
					responseCode = "404", 
					description = "No item could be deleted with the input criteria.", 
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
					name = "itemId",
					allowEmptyValue = false, 
					required = false, 
					description = "Enter the item ID of the item to delete."),
				@Parameter(
					name = "itemName",
					allowEmptyValue = false, 
					required = false, 
					description = "Enter the name of the item to delete.")
			}
		)
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<Item> deleteItem(
		@RequestParam(required = false) 
		String itemId,
		@RequestParam(required = false) 
		String itemName);
	// @formatter:on
}
