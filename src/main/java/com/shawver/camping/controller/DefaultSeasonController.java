package com.shawver.camping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shawver.camping.entity.SeasonResult;
import com.shawver.camping.service.SeasonService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leeshawver
 *
 */

@RestController
@Slf4j
public class DefaultSeasonController implements SeasonController{
	
	@Autowired
	private SeasonService seasonService;

	@Override
	public List<SeasonResult> fetchAllSeasons() {
		log.info("fetch all seasons from controller");
		return seasonService.fetchAllSeasons();
	}
}
