package com.example.DepartmentService.service.Impl;

import org.springframework.stereotype.Service;

import com.example.DepartmentService.entity.Department;
import com.example.DepartmentService.exception.DepartmentIdNotFoundException;
import com.example.DepartmentService.repository.DepartmentRepository;
import com.example.DepartmentService.service.DepartmentService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentRepository departmentRepository;

	DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;

	}

	@Override
	public Department savingDepartment(Department department) {
		log.info("department saving ; {}", department);
		Department department1 = departmentRepository.save(department);
		log.info("department saved successfully:{}", department1);
		return department1;
	}

	@Override
	public Department getDepartmentById(int departmentId) {
		log.info("feched department successfully:{}", departmentId);
		Department departmentByIds = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new DepartmentIdNotFoundException("Department ID not found: " + departmentId));
		return departmentByIds;
	}
 
}
