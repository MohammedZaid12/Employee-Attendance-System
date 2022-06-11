package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.DepartmentDto;
import com.company.employeeattendance.entities.Department;
import com.company.employeeattendance.repositories.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll(Sort.by(Sort.Order.by("name")).ascending());
    }

    @Override
    public List<Department> findAllActive() {
        return departmentRepository.findAllActiveIs(true);
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findDepartmentById(id);
    }

    @Override
    public Department save(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public DepartmentDto saveByDto(DepartmentDto departmentDto) {
        Department department = departmentDto.getId() == null ? new Department() : findById(departmentDto.getId());
        department.setCurrentUser();
        BeanUtils.copyProperties(departmentDto, department);
        Department saved = save(department);
        departmentDto.setId(saved.getId());
        return departmentDto;
    }

    @Override
    public DepartmentDto findByIdDto(Integer id) {
        DepartmentDto departmentDto = new DepartmentDto();
        BeanUtils.copyProperties(findById(id), departmentDto);
        return departmentDto;
    }
}
