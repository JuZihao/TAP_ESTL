package com.example.esm.service.impl;

import com.example.esm.entity.Employee;
import com.example.esm.dao.EmployeeDao;
import com.example.esm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Employee service implementation layer
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    /**
     * Search by Id
     *
     * @param id
     * @return
     */
    @Override
    public Employee queryById(String id) {
        return this.employeeDao.queryById(id);
    }

    /**
     * pagination
     *
     * @param employee
     * @param pageRequest
     * @return
     */
    @Override
    public Page<Employee> queryByPage(Employee employee, PageRequest pageRequest) {
        long total = this.employeeDao.count(employee);
        return new PageImpl<>(this.employeeDao.queryAllByLimit(employee, pageRequest), pageRequest, total);
    }

    /**
     * insert employee record
     *
     * @param employee
     * @return
     */
    @Override
    public Employee insert(Employee employee) {
        this.employeeDao.insert(employee);
        return employee;
    }

    /**
     * update employee record
     *
     * @param employee
     * @return
     */
    @Override
    public Employee update(Employee employee) {
        this.employeeDao.update(employee);
        return this.queryById(employee.getId());
    }

    /**
     * delete employee record
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(String id) {
        return this.employeeDao.deleteById(id) > 0;
    }

    @Override
    public int insertOrUpdateBatch(List<Employee> employees) {
        return this.employeeDao.insertOrUpdateBatch(employees);
    }
}
