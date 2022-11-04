package com.shawver.camping.service;

import java.util.List;

import com.shawver.camping.entity.SeasonResult;

/**
 * @author leeshawver
 *
 */
public interface SeasonService {

	/**
	 * @param season
	 * @return
	 */
	List<SeasonResult> fetchAllSeasons();
}
