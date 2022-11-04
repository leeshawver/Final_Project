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
public class DefaultConditionDao implements ConditionDao{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public String createCondition(String condition) {
		log.info("DAO: condition={}", condition);
		// @formatter:off
		String sql = ""
			+ "INSERT INTO item_condition ("
			+ "item_condition"
			+ ") VALUES ("
			+ ":condition)";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("condition", condition);


		jdbcTemplate.update(sql, params);
		return condition;
	}
}
