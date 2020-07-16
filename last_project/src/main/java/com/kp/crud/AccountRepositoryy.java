/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud;

import com.kp.crud.entities.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Yosef Febrianes
 */
public interface AccountRepositoryy extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);
}