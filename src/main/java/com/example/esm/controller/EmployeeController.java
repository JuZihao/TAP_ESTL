package com.example.esm.controller;

import com.example.esm.common.CSVReader;
import com.example.esm.entity.Employee;
import com.example.esm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Employee controller layer
 */
@RestController
@RequestMapping("users")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    /**
     * pagination
     *
     * @param employee
     * @param pageRequest
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<Employee>> queryByPage(Employee employee, PageRequest pageRequest) {
        return ResponseEntity.ok(this.employeeService.queryByPage(employee, pageRequest));
    }

    /**
     * Search by id
     *
     * @param id
     * @return Single record
     */
    @GetMapping("{id}")
    public ResponseEntity<Employee> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.employeeService.queryById(id));
    }

    /**
     * Add employee record
     *
     * @param employee
     * @return
     */
    @PostMapping
    public ResponseEntity<Employee> add(Employee employee) {
        return ResponseEntity.ok(this.employeeService.insert(employee));
    }

    /**
     * update employee record
     *
     * @param employee
     * @return
     */
    @PutMapping
    public ResponseEntity<Employee> edit(Employee employee) {
        return ResponseEntity.ok(this.employeeService.update(employee));
    }

    /**
     * Delete employee record by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.employeeService.deleteById(id));
    }

    /**
     * upload csv file
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResponseEntity<Integer> upload(@RequestParam("file") MultipartFile file) throws IOException {
        //TODO check file extension is csv or txt
        if ("text/csv".equals(file.getContentType())) {
            List<Employee> employees = CSVReader.readEmployeeDataFromCsv(file.getInputStream());
            return ResponseEntity.ok(this.employeeService.insertOrUpdateBatch(employees));
        }
        return ResponseEntity.ok(1);
    }
}

