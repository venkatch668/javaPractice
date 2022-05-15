package com.weshopify.platform.features.categories;

import java.util.List;


public interface CategoryService {

	public CategoryBean saveCategory(CategoryBean CategoryBean);
	public CategoryBean updateCategory(CategoryBean CategoryBean);
	public List<CategoryBean> findAllCategories();
	public CategoryBean findCategoryById(int categoryId);
	public List<CategoryBean> deleteCategory(int categoryId);
	
	//filter Parameters 
	public List<CategoryBean> searchCategory();
	
}
