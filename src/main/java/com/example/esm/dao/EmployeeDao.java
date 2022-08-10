package com.example.esm.dao;

import com.example.esm.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Employee dao layer
 */
@Mapper
public interface EmployeeDao {

    /**
     * Search by id
     *
     * @param id
     * @return
     */
    Employee queryById(String id);

    /**
     * Query by limit
     *
     * @param employee
     * @param pageable
     * @return
     */
    List<Employee> queryAllByLimit(Employee employee, @Param("pageable") Pageable pageable);

    /**
     * Total count of employee
     *
     * @param employee
     * @return
     */
    long count(Employee employee);

    /**
     * insert employee record
     *
     * @param employee
     * @return
     */
    int insert(Employee employee);

    /**
     * insert employees
     *
     * @param entities List<Employee>
     * @return
     */
    int insertBatch(@Param("entities") List<Employee> entities);

    /**
     * update employees
     *
     * @param entities List<Employee>
     * @return
     * @throws org.springframework.jdbc.BadSqlGrammarException
     */
    int insertOrUpdateBatch(@Param("entities") List<Employee> entities);

    /**
     * update employee record
     *
     * @param employee
     * @return
     */
    int update(Employee employee);

    /**
     * delete employee record
     *
     * @param id
     * @return
     */
    int deleteById(String id);

}

