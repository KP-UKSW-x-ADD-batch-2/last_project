/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Employee;
import com.kp.crud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yosef Febrianes
 */
@Controller
public class EmployeeLeaveController {
    @Autowired
    EmployeeService employeeService;
    
    @RequestMapping("employeeleave")
    public String employeView(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", employeeService.employeeViewLeave());
//        for (Employee employee : employeeService.employeeView()) {
//                System.out.println(employee.getId());
//            }
        return "employeeleave";
    }
    
//    @PostMapping("findemployee")
//    public String findEmployee(Model model, @Validated Employee id) {
//        employeeService.searchById(id.getId());
//        model.addAttribute("employee", new Employee());
//        model.addAttribute("employees", employeeService.searchById(id.toString()));
//        return "redirect:/";
//    }
    
    
    
//    @RequestMapping("")
//    public String request(Model model){
//        model.addAttribute("request", new Request());
//        model.addAttribute("requests", employeeService.getAll());
//        return "index";
//    }
    
}
