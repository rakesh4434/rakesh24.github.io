package com.tcs.org.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.Category;
import com.tcs.org.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public Map<String,List<Category>> getAllCategoryVlues() {
		return categoryService.getAllCategoryVlues();
	}
	

}
