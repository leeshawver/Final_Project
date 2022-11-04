package com.shawver.camping.dao;

import java.util.List;

import com.shawver.camping.entity.SeasonResult;

/**
 * @author leeshawver
 *
 */
public interface SeasonDao {
	/**
	 * @return
	 */
	List<SeasonResult> fetchAllSeasons();
}
