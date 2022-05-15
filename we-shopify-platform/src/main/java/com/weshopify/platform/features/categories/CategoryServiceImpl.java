/**
 * 
 */
package com.weshopify.platform.features.categories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;


/**
 * @author IM-LP-1763
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	//private static Set<CategoryBean> IN_MEMORY_DB = new HashSet<CategoryBean>();
	private static Map<Integer, CategoryBean> IN_MEMORY_DB = new HashMap<Integer, CategoryBean>();

	/**
	 * if the id is there in the customer bean
	 * then update the database with the data that is coming inside
	 * the customer bean else save it as new customer
	 */
	@Override
	public CategoryBean saveCategory(CategoryBean CategoryBean) {
		
		if(CategoryBean.getCategoryId() != 0) {
			IN_MEMORY_DB.put(CategoryBean.getCategoryId(),CategoryBean);
		}else {
			int categoryId = new Random().nextInt();
			CategoryBean.setCategoryId(categoryId);
			IN_MEMORY_DB.put(categoryId,CategoryBean);
		}
		
		return CategoryBean;
	}

	@Override
	public CategoryBean updateCategory(CategoryBean CategoryBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryBean> findAllCategories() {
		// TODO Auto-generated method stub
		List<CategoryBean> categoriesList = new ArrayList<CategoryBean>(IN_MEMORY_DB.values());
		return categoriesList;
	}

	@Override
	public CategoryBean findCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryBean> deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryBean> searchCategory() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public CategoryBean updateCustomer(CategoryBean CategoryBean) {
//		IN_MEMORY_DB.put(CategoryBean.getCustomerId(),CategoryBean);
//		return CategoryBean;
//	}
//
//	@Override
//	public List<CategoryBean> findAllCustomers() {
//		// TODO Auto-generated method stub
//		List<CategoryBean> customerList = new ArrayList<CategoryBean>(IN_MEMORY_DB.values());
//		return customerList;
//	}
//
//	@Override
//	public CategoryBean findCustomerById(int customerId) {
//		return IN_MEMORY_DB.get(customerId);
//	}
//
//	@Override
//	public List<CategoryBean> deleteCustomer(int customerId) {
//		IN_MEMORY_DB.remove(customerId);
//		List<CategoryBean> customerList = new ArrayList<CategoryBean>(IN_MEMORY_DB.values());
//		return customerList;
//	}
//
//	@Override
//	public List<CategoryBean> searchCustomer() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
