package com.example.backendrecette.jwtModule.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendrecette.jwtModule.Dto.LoginRequest;
import com.example.backendrecette.jwtModule.Dto.SignupRequest;
import com.example.backendrecette.jwtModule.models.AppUser;
import com.example.backendrecette.jwtModule.repositories.UserRepository;
import com.example.backendrecette.jwtModule.services.MyUserDetailsService;
import com.example.backendrecette.jwtModule.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        AppUser user = AppUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role("ADMIN").build();
        userRepository.save(user);

        return jwtUtil.generateToken(user.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
    
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
    
            AppUser user = userRepository.findByUsername(request.getUsername()).orElseThrow();
    
            Map<String, Object> response = new HashMap<>();
            response.put("token", jwt);
            response.put("role", user.getRole());
    
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants invalides !");
        }
    }
    

}
