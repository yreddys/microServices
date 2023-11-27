package com.example.DepartmentService.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.DepartmentService.entity.Department;
import com.example.DepartmentService.exception.DepartmentIdNotFoundException;
import com.example.DepartmentService.repository.DepartmentRepository;
import com.example.DepartmentService.service.Impl.DepartmentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class testDepartment {
	@Mock
	private DepartmentRepository repo;
	@InjectMocks
	private DepartmentServiceImpl service;

	@Test
	void testDepartment() {
		Department department = new Department();
		department.setDepartmentId(1);
		department.setDepartmentAddress("Hello");
		department.setDepartmentName("Hi");

		when(repo.save(department)).thenReturn(department);
		Department actualDepartment = service.savingDepartment(department);
		assertEquals(department, actualDepartment);
		verify(repo, times(1)).save(department);
	}

	@Test
	void testGetDepartmentById_WhenDepartmentNotFound() {
		int nonExistentDepartmentId = 999;
		 when(repo.findById(nonExistentDepartmentId)).thenReturn(Optional.empty());
		 assertThrows(DepartmentIdNotFoundException.class, () -> {
	            service.getDepartmentById(nonExistentDepartmentId);
	        });
	}
}