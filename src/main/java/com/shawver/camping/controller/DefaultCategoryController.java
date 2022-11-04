package com.shawver.camping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shawver.camping.service.CategoryService;

import lombok.extern.slf4j.Slf4j;
/**
 * @author leeshawver
 *
 */

@RestController
@Slf4j
public class DefaultCategoryController implements CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@Override
	public String createCategory(String category) {
		log.info("category={}", category);
		return categoryService.createCategory(category);
	}
}
