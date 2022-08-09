package com.esm.service;

import com.esm.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Employee service layer
 */
public interface EmployeeService {

    /**
     * search by id
     *
     * @param id
     * @return
     */
    Employee queryById(String id);

    /**
     * pagination
     *
     * @param employee
     * @param pageRequest
     * @return
     */
    Page<Employee> queryByPage(Employee employee, PageRequest pageRequest);

    /**
     * insert employee record
     *
     * @param employee
     * @return
     */
    Employee insert(Employee employee);

    /**
     * update employee record
     *
     * @param employee
     * @return
     */
    Employee update(Employee employee);

    /**
     * delete employee record
     *
     * @param id
     * @return
     */
    boolean deleteById(String id);

    /**
     * insert or update employee records
     *
     * @param employees
     * @return
     */
    int insertOrUpdateBatch(List<Employee> employees);
}
