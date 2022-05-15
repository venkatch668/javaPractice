package com.weshopify.platform.features.categories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CategoryController {

	Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

//	@RequestMapping(value = { "/customer" }, method = RequestMethod.GET)
//	public String customerSelfSignupPage() {
//		log.info("in render signup page method");
//		return "sign-up.html";
//	}
//	
	@RequestMapping(value = { "/add-category" }, method = RequestMethod.GET)
	public String customerAdminSignupPage(Model model) {
		log.info("in add-category");
		model.addAttribute("category", new CategoryBean());
		return "add-category.html";
	}
//	
	@RequestMapping(value = { "/view-categories" }, method = RequestMethod.GET)
	public String viewCustomersPage(Model model) {
		List<CategoryBean> categoriesList = categoryService.findAllCategories();
		model.addAttribute("categoriesList", categoriesList);
		return "view-categories.html";
	}
//	
//	@RequestMapping(value = { "/delete-customers/{customerId}" }, method = RequestMethod.GET)
//	public String deleteCustomers(@PathVariable("customerId") int customerId, Model model) {
//		
//		log.info("deleteing the customet by the customer Id {}",customerId);
//		
//		List<CategoryBean> customersList = customerService.deleteCustomer(customerId);
//		model.addAttribute("customersList", customersList);
//		return "customer.html";
//	}
//
//
	@RequestMapping(value = { "/category" }, method = RequestMethod.POST)
	public String createCategory(CategoryBean category, Model model) {
	
		category = categoryService.saveCategory(category);
		if (category.getCategoryId() > 0) {

			String message = "category Registration Successfull";
			model.addAttribute("message", message);
		}
			return "redirect:/view-categories";
		
		
	}
//	
//	@RequestMapping(value = { "/edit-customers/{customerId}" }, method = RequestMethod.GET)
//	public String editCustomer(@PathVariable("customerId") int customerId, Model model) {
//		log.info("customer ID in Edit Customer Page:\t"+customerId);
//		CategoryBean customer = customerService.findCustomerById(customerId);
//		model.addAttribute("customer",customer);
//		return "customer-admin-reg.html";
//		
//	}

}
