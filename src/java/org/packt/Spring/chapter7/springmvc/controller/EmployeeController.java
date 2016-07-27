/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.packt.Spring.chapter7.springmvc.controller;

import org.packt.Spring.chapter7.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author SPPDF
 */
@Controller
//@RequestMapping("/employee")
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String welcomeEmployee(ModelMap model){
        model.addAttribute("name", "Hello World!");
        model.addAttribute("greetings", "Welcome to packt Publishing - Spring MVC !!!!");
        return "hello";
//        return "test";
//        return "/WEB-INF/views/hello.jsp";
    }
    
    @RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
    public String listEmployees(ModelMap model){
        model.addAttribute("lista", "esta es la lista: "+employeeService.getAllEmployees());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee";
    }
    
    
    
}
