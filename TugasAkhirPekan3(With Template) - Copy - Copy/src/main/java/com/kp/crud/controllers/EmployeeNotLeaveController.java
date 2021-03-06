/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Employees;
import com.kp.crud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dhanuaji Pratama
 */
@Controller
public class EmployeeNotLeaveController {
    @Autowired
    EmployeeRepository employeeRepository;
    
    @RequestMapping("employeenotleave")
    public String showEmployeeNotLeave(Model model){
        model.addAttribute("employee", new Employees());
        model.addAttribute("employees", employeeRepository.employeenotleave());
        return "employeenotleave";
    }
}
