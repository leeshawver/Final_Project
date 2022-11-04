package com.shawver.camping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shawver.camping.service.ConditionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leeshawver
 *
 */


@RestController
@Slf4j
public class DefaultConditionController implements ConditionController{
	@Autowired
	private ConditionService conditionService;

	@Override
	public String createCondition(String condition) {
		log.info("condition={}", condition);
		return conditionService.createCondition(condition);
	}
}
