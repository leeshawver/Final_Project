package com.shawver.camping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.shawver.camping.entity.Category;
import com.shawver.camping.entity.Condition;
import com.shawver.camping.entity.Item;
import com.shawver.camping.entity.Season;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leeshawver
 *
 */

@Component
@Slf4j
public class DefaultItemDao implements ItemDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * @param season
	 * @return
	 */
	@Override
	public List<Item> fetchItemsBySeason(Season season) {
				
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM item i "
			+ "INNER JOIN season s ON i.season_fk = s.season "
			+ "WHERE s.season = :season";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("season", season.toString());
		
		return jdbcTemplate.query(sql, params, 
			new RowMapper<>() {
				@Override
				public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
					// @formatter:off
					return Item.builder()
						.item_pk(rs.getLong("item_pk"))
						.item_id(rs.getString("item_id"))
						.item_name(rs.getString("item_name"))
						.item_manufacturer(rs.getString("item_manufacturer"))
						.build();
					// @formatter:on
				}});
	}

	/**
	 * @param condition
	 * @return
	 */
	@Override
	public List<Item> fetchItemsByCondition(Condition item_condition) {
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM item "
			+ "WHERE item_condition_fk = :item_condition";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("item_condition", item_condition.toString());
		
		return jdbcTemplate.query(sql, params, 
			new RowMapper<>() {
				@Override
				public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
					// @formatter:off
					return Item.builder()
						.item_pk(rs.getLong("item_pk"))
						.item_id(rs.getString("item_id"))
						.item_name(rs.getString("item_name"))
						.item_manufacturer(rs.getString("item_manufacturer"))
						.build();
					// @formatter:on
				}});
	}

	/**
	 * @param category
	 * @return
	 */
	public List<Item> fetchItemsByCategory(Category category) {
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM item "
			+ "WHERE category_fk = :category";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("category", category.toString());
		
		return jdbcTemplate.query(sql, params, 
			new RowMapper<>() {
				@Override
				public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
					// @formatter:off
					return Item.builder()
						.item_pk(rs.getLong("item_pk"))
						.item_id(rs.getString("item_id"))
						.item_name(rs.getString("item_name"))
						.item_manufacturer(rs.getString("item_manufacturer"))
						.build();
					// @formatter:on
				}});
	}
	
	@Override
	public List<Item> fetchAllItems() {
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM item";
		// @formatter:on
		
		return jdbcTemplate.query(sql, 
			new RowMapper<>() {
				@Override
				public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
					// @formatter:off
					return Item.builder()
						.item_pk(rs.getLong("item_pk"))
						.item_id(rs.getString("item_id"))
						.item_name(rs.getString("item_name"))
						.item_manufacturer(rs.getString("item_manufacturer"))
						.build();
					// @formatter:on
				}});
	}

	@Override
	public Optional<Item> createItem(
			String itemId, 
			String itemName, 
			String itemManufacturer, 
			Season season,
			Condition item_condition, 
			Category category) {
		log.info("DAO: itemName={}, itemManufacturer={}", itemName, itemManufacturer);
		// @formatter:off
		String sql = ""
			+ "INSERT INTO item ("
			+ "item_id, item_name, item_manufacturer,season_fk, item_condition_fk, category_fk"
			+ ") VALUES ("
			+ ":item_id, :item_name, :item_manufacturer, :season, :item_condition, :category)";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("item_id", itemId);
		params.put("item_name", itemName);
		params.put("item_manufacturer", itemManufacturer);
		params.put("season", season.toString());
		params.put("item_condition", item_condition.toString());
		params.put("category", category.toString());


		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Item.builder()
			.item_id(itemId)
			.item_name(itemName)
			.item_manufacturer(itemManufacturer)
			.build());
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
		
		log.info(
			"DAO: itemId={}, itemName={}, newManufacturer={}, newName={}, newSeason={}, newCondition={}, newCategory={}",
			itemId, itemName, newManufacturer, newName, newSeason, newCondition, newCategory);
		// @formatter:off
		String sql = ""
			+ "UPDATE item "
			+ "SET item_name = :new_name, "
			+ "item_manufacturer = :new_manufacturer, "
			+ "season_fk = :new_season, "
			+ "item_condition_fk = :new_condition, "
			+ "category_fk = :new_category "
			+ "WHERE item_id = :item_id AND item_name = :item_name";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("item_id", itemId);
		params.put("item_name", itemName);
		params.put("new_manufacturer", newManufacturer);
		params.put("new_name", newName);
		params.put("new_season", newSeason.toString());
		params.put("new_condition", newCondition.toString());
		params.put("new_category", newCategory.toString());

		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Item.builder()
			.item_id(itemId)
			.item_name(newName)
			.item_manufacturer(newManufacturer)
			.build());
	}
	
	@Override
	public Optional<Item> deleteItem(String itemId, String itemName) {
		log.info("DAO: itemId = {}, itemName={}", itemId, itemName);
		// @formatter:off
		String sql = ""
			+ "DELETE FROM item WHERE "
			+ "item_id = :item_id AND "
			+ "item_name = :item_name";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("item_id", itemId);
		params.put("item_name", itemName);

		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Item.builder()
				.item_id(itemId)
				.item_name(itemName)
				.build());
	}
}
