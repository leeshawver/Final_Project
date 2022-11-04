package com.shawver.camping.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawver.camping.dao.SeasonDao;
import com.shawver.camping.entity.SeasonResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leeshawver
 *
 */

@Service
@Slf4j
public class DefaultSeasonService implements SeasonService{
	@Autowired
	private SeasonDao seasonDao;
	
	@Override
	public List<SeasonResult> fetchAllSeasons() {
		log.info("The fetchAllSeasons method was called");
		List<SeasonResult> seasons = seasonDao.fetchAllSeasons();
		
		if (seasons.isEmpty()) {
			String msg = String.format("No seasons found");
			throw new NoSuchElementException(msg);
		}
		
		return seasons;
	}
}
