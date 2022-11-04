package com.shawver.camping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawver.camping.dao.ConditionDao;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leeshawver
 *
 */

@Service
@Slf4j
public class DefaultConditionService implements ConditionService{
	@Autowired
	private ConditionDao conditionDao;
	
	@Override
	public String createCondition(String condition) {
		log.info("The createCondition method was called with condition={}", condition);
		return conditionDao.createCondition(condition);
	}
}
