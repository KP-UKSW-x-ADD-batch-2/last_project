/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Account;
import com.kp.crud.entities.Role;
import com.kp.crud.repositories.AccountRepository;
import com.kp.crud.repositories.RoleRepository;
import com.kp.crud.services.AccountService;
import com.kp.crud.services.RoleService;
import com.kp.crud.tools.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yosef Febrianes
 */
@Controller
public class LoginController {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository repository;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("roles", roleService.getAll());
        return "index";
    }

    @PostMapping("findlogin")
    public String findLogin(Model model, @Validated Account id) {
        accountService.getById(id.getId());
        model.addAttribute("account", new Account());
        model.addAttribute("accounts", accountService.getById(id.toString()));
        return "redirect:/";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String error, String logout) {
//        if (error != null) {
//            model.addAttribute("errorMsg", "Your username and password are invalid.");
//        }
//
//        if (logout != null) {
//            model.addAttribute("msg", "You have been logged out successfully.");
//        }
//
//        return "dashboard";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("roless", roleService.getAll());
        System.out.println("LOGIN ON");

        accountService.getByUsername("username", "password");
        if (true) {
            return "login";
        } else {
            return "login";
        }
    }
    
    
//    @PostMapping("login")
//    public boolean login(Model model, @Validated String username, String password) {
//        Account acc = (Account) accountService.getByUsername(username);
//
//        if (acc != null && BCrypt.checkpw(password, acc.getPassword())) {
////        if (BCrypt.checkpw(password, acc.getPassword())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
