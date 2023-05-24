package com.example.demo.controller;


import com.example.demo.Payload.LoginRequest;
import com.example.demo.configuration.AccountDetails;
import com.example.demo.configuration.JwtTokenProvider;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public Map<String,Object> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Account account = accountRepository.findAccountByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        String role=account.getRole().getName();
        String token = tokenProvider.generateToken(new AccountDetails(account));
        Map<String, Object> response = new HashMap<>();
        response.put("code",200);
        response.put("role",role);
        response.put("token", token);

        return response;
    }





}
