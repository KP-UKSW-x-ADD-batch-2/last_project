/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Employee;
import com.kp.crud.entities.Report;
import com.kp.crud.entities.Request;
import com.kp.crud.services.EmployeeService;
import com.kp.crud.services.ReportService;
import com.kp.crud.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yosef Febrianes
 */
@Controller
public class RequestController {
    
    @Autowired
    RequestService requestService;
    
    @Autowired 
    ReportService reportService;
    
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("request")
    public String request(Model model) {
//        model.addAttribute("requestall", requestService.getAll());
        model.addAttribute("report", new Report());
        model.addAttribute("reports", reportService.reportView());
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", employeeService.employeeViewLeave());
        return "request";
    }
    
    @PostMapping("request")
    public String insert(Model model, @Validated Request request) {
        model.addAttribute("request", new Request());
//        model.addAttribute("requests", requestService.insertRequest());
        requestService.save(request);
        return "redirect:/";
    }
}