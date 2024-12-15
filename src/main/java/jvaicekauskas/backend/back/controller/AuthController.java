package jvaicekauskas.backend.back.controller;

import jvaicekauskas.backend.back.security.JwtUtil;
import jvaicekauskas.backend.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginData) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginData.get("username"), loginData.get("password")
            ));
            String token = jwtUtil.generateToken(loginData.get("username"));
            return Map.of("token", token);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
