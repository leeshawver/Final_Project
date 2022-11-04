package com.shawver.camping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawver.camping.dao.CategoryDao;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leeshawver
 *
 */

@Service
@Slf4j
public class DefaultCategoryService implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public String createCategory(String category) {
		log.info("The createCategory method was called with category={}", category);		
		return categoryDao.createCategory(category);
	}
}
