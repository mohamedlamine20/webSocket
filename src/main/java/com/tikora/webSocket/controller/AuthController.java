package com.tikora.webSocket.controller;

import com.tikora.webSocket.dto.Token;
import com.tikora.webSocket.dto.UserDTO;
import com.tikora.webSocket.dto.loginRequest;
import com.tikora.webSocket.jwt.JwtService;
import com.tikora.webSocket.models.User;
import com.tikora.webSocket.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/signup")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserDTO> signup(@RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.ok(userService.save(userDTO));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody @Valid  loginRequest request){
        User user =userService.getByEmail(request.getEmail())
                .orElseThrow( () -> new NotFoundException("bad credential"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword()));
        return ResponseEntity.ok(new Token(jwtService.generateToken(user)));

    }


}
