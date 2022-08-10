package com.example.esm.common;


import com.example.esm.entity.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Employee> readEmployeeDataFromCsv(InputStream inputStream ) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {
                if (line.startsWith("#")) {
                    line = br.readLine();
                    continue;
                }

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Employee employee = createEmployeeData(attributes);

                // adding employee into ArrayList
                employees.add(employee);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        return employees;
    }


    private static Employee createEmployeeData(String[] employeeData) {
        return new Employee(employeeData[0], employeeData[1], employeeData[2], Double.parseDouble(employeeData[3]));
    }
}
