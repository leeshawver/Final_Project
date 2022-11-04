package com.shawver.camping.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leeshawver
 *
 */

@Component
@Slf4j
public class DefaultCategoryDao implements CategoryDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public String createCategory(String category) {
		log.info("DAO: category={}", category);
		// @formatter:off
		String sql = ""
			+ "INSERT INTO category ("
			+ "category"
			+ ") VALUES ("
			+ ":category)";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("category", category);


		jdbcTemplate.update(sql, params);
		return category;
	}
}
