package wuhao.springboot.configure.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wuhao.springboot.configure.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PC
 */
@RestController
@RequestMapping("/api/jwt")
@AllArgsConstructor
public class JwtController {
    private JwtUtil jwtUtil;

    @PostMapping("/generate")
    public Map<String,String> generateToken(@RequestParam String username) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("username", username);
        String token = jwtUtil.generateToken(claims);
        Map<String,String> reaponse = new HashMap<>();
        reaponse.put("token", token);
        return reaponse;
    }

    @PostMapping("/validate")
    public Map<String,Object> validateToken(@RequestParam String token) {
        boolean isvalid = jwtUtil.validateToken(token);
        Map<String,Object> response = new HashMap<>();
        response.put("valid", isvalid);
        return response;
    }
}
