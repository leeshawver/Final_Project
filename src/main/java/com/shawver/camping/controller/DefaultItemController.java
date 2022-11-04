package com.shawver.camping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shawver.camping.entity.Category;
import com.shawver.camping.entity.Condition;
import com.shawver.camping.entity.Item;
import com.shawver.camping.entity.Season;
import com.shawver.camping.service.ItemService;

import lombok.extern.slf4j.Slf4j;
/**
 * @author leeshawver
 *
 */

@RestController
@Slf4j
public class DefaultItemController implements ItemController {
	
	@Autowired
	private ItemService campingInventoryService;

	@Override
	public List<Item> fetchItemsBySeason(Season season) {
		log.info("season={}", season);
		return campingInventoryService.fetchItemsBySeason(season);
	}
	
	@Override
	public List<Item> fetchItemsByCondition(Condition condition) {
		log.info("condition={}", condition);
		return campingInventoryService.fetchItemsByCondition(condition);
	}
	
	@Override
	public List<Item> fetchItemsByCategory(Category category) {
		log.info("category={}", category);
		return campingInventoryService.fetchItemsByCategory(category);
	}

	@Override
	public List<Item> fetchAllItems() {
		log.info("fetch all items from controller");
		return campingInventoryService.fetchAllItems();
	}

	@Override
	public Optional<Item> createItem(
		String itemId, 
		String itemName,
		String itemManufacturer, 
		Season season,
		Condition condition, 
		Category category) {
		log.info("create an item");
		return campingInventoryService.createItem(
			itemId,itemName, itemManufacturer, season, condition, category);
	}

	@Override
	public Optional<Item> updateItem(
		String itemId, 
		String itemName,
		String newManufacturer,
		String newName,
		Season newSeason,
		Condition newCondition,
		Category newCategory) {
		log.info("update an item's name, manufacturer, season, condition, and/or category.");
		return campingInventoryService.updateItem(
			itemId, itemName, newManufacturer, newName, newSeason, newCondition, newCategory);
	}
	
	@Override
	public Optional<Item> deleteItem(
		String itemId,
		String itemName) {
		return campingInventoryService.deleteItem(itemId, itemName);
	}
}
