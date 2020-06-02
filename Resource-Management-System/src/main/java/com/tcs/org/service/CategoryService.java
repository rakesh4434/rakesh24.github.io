package com.tcs.org.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.Category;
import com.tcs.org.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Map<String, List<Category>> getAllCategoryVlues() {
		
		List<Category> categoriesList = categoryRepository.findAll();
		
		Map<String, List<Category>> categoryMap = categoriesList.stream().
				collect(Collectors.groupingBy(Category::getCatType));
		
		return categoryMap;
	}

}