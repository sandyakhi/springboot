package com.satya.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.satya.mvc.employee.EmployeeModel;
import com.satya.mvc.entity.EmployeeEntity;
import com.satya.mvc.service.EmployeeService;



@Controller
public class TestController
{
		@Autowired
		EmployeeService employeeService;
		
		@GetMapping("/addEmployee")
		public String getEmployee()
		{
			return "add-employee";
		}
		@PostMapping("/saveEmployee")
		public String setEmployee(EmployeeModel employeeModel)
		{
			
			employeeService.setEmployee(employeeModel);
			return "submitt";
		}
		@GetMapping("/getemployeedetails")
		public String getEmployeeDetails(Model model) 
		{
			List<EmployeeEntity> employees=employeeService.getEmployeeDetails();
			model.addAttribute("employees", employees);
			return "employee-list";
		}
		
		@GetMapping("/getsearchform")
		public String getSearchForm()
		{
			
			return "search-employee";
		}
		@PostMapping("/searchbyid")
		public String postMethodName(@RequestParam Integer id, Model model) {
			
			EmployeeEntity employee=employeeService.searchByID(id);
			model.addAttribute("employee",employee);
			return "search-employee";
		}
		
		@GetMapping("/delete/{id}")
		public String deleteEmployeeById(@PathVariable("id") Integer id) {
			
			employeeService.deleteEmployeeById(id);
			
			return "redirect:/getemployeedetails";
		}
		
		

	}
		