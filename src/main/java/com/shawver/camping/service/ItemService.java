package com.shawver.camping.service;

import java.util.List;
import java.util.Optional;

import com.shawver.camping.entity.Category;
import com.shawver.camping.entity.Condition;
import com.shawver.camping.entity.Item;
import com.shawver.camping.entity.Season;

/**
 * @author leeshawver
 *
 */
public interface ItemService {

	/**
	 * @param season
	 * @return
	 */
	List<Item> fetchItemsBySeason(Season season);

	/**
	 * @param condition
	 * @return
	 */
	List<Item> fetchItemsByCondition(Condition condition);

	/**
	 * @param category
	 * @return
	 */
	List<Item> fetchItemsByCategory(Category category);

	/**
	 * @return
	 */
	List<Item> fetchAllItems();

	/**
	 * @param itemId
	 * @param itemName
	 * @param itemManufacturer
	 * @param season
	 * @param condition
	 * @param category
	 * @return
	 */
	Optional<Item> createItem(
		String itemId, 
		String itemName, 
		String itemManufacturer, 
		Season season,
		Condition condition, 
		Category category);

	/**
	 * @param itemId
	 * @param itemName
	 * @param newManufacturer
	 * @param newName
	 * @param newSeason
	 * @param newCondition
	 * @param newCategory
	 * @return
	 */
	Optional<Item> updateItem(
		String itemId, 
		String itemName,
		String newManufacturer,
		String newName,
		Season newSeason,
		Condition newCondition,
		Category newCategory);

	/**
	 * @param itemId
	 * @param itemName
	 * @return
	 */
	Optional<Item> deleteItem(String itemId, String itemName);
}
