package com.example.DepartmentService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DepartmentService.entity.Department;
import com.example.DepartmentService.service.DepartmentService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/department")
public class DepartmentController {
	private DepartmentService departmentService;

	DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;

	}

	@PostMapping("/save")
	String saveDepartment(@RequestBody Department department) {
		log.info("saving requested department :{}", department);
		departmentService.savingDepartment(department);
		log.info("department saved successfully :{}", department);
		return "Department Saved successfully" +" : "+ department.getDepartmentId();
	}

	@GetMapping("{departmentId}")
	Department getDepartmentById(@PathVariable int departmentId) {
		log.info("requested departmentId :{}", departmentId);
		Department departmentById = departmentService.getDepartmentById(departmentId);
		log.info("department fetched successfully:{}", departmentById);
		return departmentById;

	}
}
