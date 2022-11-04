package com.shawver.camping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.shawver.camping.entity.SeasonResult;

/**
 * @author leeshawver
 *
 */

@Component
public class DefaultSeasonDao implements SeasonDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<SeasonResult> fetchAllSeasons() {
		String sql = "SELECT * FROM season";
		
		return jdbcTemplate.query(sql, 
			new RowMapper<>() {
				@Override
				public SeasonResult mapRow(ResultSet rs, int rowNum) throws SQLException {
					// @formatter:off
					return SeasonResult.builder()
						.season(rs.getString("season"))
						.build();
					// @formatter:on
				}});
	}
}
