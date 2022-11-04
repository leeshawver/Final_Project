package com.shawver.camping.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shawver.camping.dao.ItemDao;
import com.shawver.camping.entity.Category;
import com.shawver.camping.entity.Condition;
import com.shawver.camping.entity.Item;
import com.shawver.camping.entity.Season;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leeshawver
 *
 */

@Service
@Slf4j
public class DefaultItemService implements ItemService {

	@Autowired
	private ItemDao campingInventoryDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Item> fetchItemsBySeason(Season season) {
		log.info("The fetchItemsBySeason method was called with season={}", season);
		List<Item> items = campingInventoryDao.fetchItemsBySeason(season);
		
		if (items.isEmpty()) {
			String msg = String.format("No items found with season=%s", season);
			throw new NoSuchElementException(msg);
		}
		
		return items;
	}

	@Override
	public List<Item> fetchItemsByCondition(Condition item_condition) {
		log.info("The fetchItemsByCondition method was called with condition={}", item_condition);
		List<Item> items = campingInventoryDao.fetchItemsByCondition(item_condition);
		
		if (items.isEmpty()) {
			String msg = String.format("No items found with condition=%s", item_condition);
			throw new NoSuchElementException(msg);
		}
		
		return items;
	}

	@Override
	public List<Item> fetchItemsByCategory(Category category) {
		log.info("The fetchItemsByCategory method was called with category={}", category);
		List<Item> items = campingInventoryDao.fetchItemsByCategory(category);
		
		if (items.isEmpty()) {
			String msg = String.format("No items found with category=%s", category);
			throw new NoSuchElementException(msg);
		}
			
		return items;
	}

	@Override
	public List<Item> fetchAllItems() {
		log.info("The fetchAllItems method was called");
		List<Item> items = campingInventoryDao.fetchAllItems();
		
		if (items.isEmpty()) {
			String msg = String.format("No items found");
			throw new NoSuchElementException(msg);
		}
		
		return items;
	}

	@Override
	public Optional<Item> createItem(
			String itemId, 
			String itemName, 
			String itemManufacturer, 
			Season season,
			Condition item_condition, 
			Category category) {
		log.info("The createItem method was called with itemId={}, "
				+ "itemName={}, "
				+ "itemManufacturer={}"
				+ "season={}"
				+ "item_condition={}"
				+ "category={}",
				itemId, itemName, itemManufacturer, season, item_condition, category);
		return campingInventoryDao.createItem(itemId, itemName, itemManufacturer, season, item_condition, category);
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
		log.info("The updateItem method was called with "
			+ "itemId={}, "
			+ "itemName={},"
			+ "newManufacturer={},"
			+ "newName={},"
			+ "newSeason={},"
			+ "newCondition={},"
			+ "newCategory={}",
			itemId, itemName, newManufacturer, newName, newSeason, newCondition, newCategory);
		return campingInventoryDao.updateItem(
			itemId, itemName, newManufacturer, newName, newSeason, newCondition, newCategory);
	}

	@Override
	public Optional<Item> deleteItem(String itemId, String itemName) {
		log.info("The deleteItem method was called with itemId={}, itemName={}", itemId, itemName);
		return campingInventoryDao.deleteItem(itemId, itemName);
	}
}
