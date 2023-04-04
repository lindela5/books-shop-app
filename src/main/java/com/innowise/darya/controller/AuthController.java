package com.innowise.darya.controller;

import com.innowise.darya.security.SecurityUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private UserDetailsService userDetailsServiceImpl;

    public AuthController(UserDetailsService userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<String> getLoginPage(@RequestBody Map<String,String> authMap) {
        System.out.println(authMap.get("login") + " " + authMap.get("password"));
        return new ResponseEntity<>(authMap.get("login"), HttpStatus.OK);
    }

    @GetMapping("/success")
    //
    public String getSuccessPage() {
        return "success";
    }
}