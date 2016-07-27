/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.packt.Spring.chapter7.springmvc.service;

import java.util.List;
import org.packt.Spring.chapter7.springmvc.model.Employee;

/**
 *
 * @author SPPDF
 */
public interface EmployeeService {
    
    // to get all employees
    public List<Employee> getAllEmployees();
    // to insert new employee
    public void insertEmployee(Employee employee);
    //to update employee
    public int updateEmployee(Employee employee);
    //to delete a row
    public int deleteEmployee(Employee employee);
    //to pagination
    public List<Employee> pagEmployee(int start, int end);
    //to criteria
    public List<Employee> criteriaEmployees();
}
