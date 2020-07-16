/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Employee;
import com.kp.crud.entities.History;
import com.kp.crud.entities.Report;
import com.kp.crud.repositories.EmployeeRepository;
import com.kp.crud.services.EmployeeService;
import com.kp.crud.services.ReportService;
import javafx.scene.layout.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yosef Febrianes
 */
@Controller
public class DashboardController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ReportService reportService;

    @RequestMapping("/dashboard")
    public String employeView(Model model) {
//        model.addAttribute("employee", new Employee());
//        model.addAttribute("employees", employeeService.employeeViewLeave());
//        model.addAttribute("history", new History());
//        model.addAttribute("histories", reportService.reportView());
//        model.addAttribute("employee", new Employee());
//        model.addAttribute("employees2", employeeService.employeeViewNotLeave());


//        for (Employee employee : employeeService.employeeView()) {
//                System.out.println(employee.getId());
//            }
        return "dashboard";
    }

}
