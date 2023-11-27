package com.example.DepartmentService.service;

import com.example.DepartmentService.entity.Department;

public interface DepartmentService {

	Department savingDepartment(Department department);

	Department getDepartmentById(int departmentId);

}
