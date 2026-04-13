package com.prisonmanager.React.service;

import com.prisonmanager.React.DTO.LoginRequest;
import com.prisonmanager.React.DTO.LoginResponse;
import com.prisonmanager.React.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.prisonmanager.React.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request){
        if (request == null || request.getName() == null || request.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name and password are required");
        }

        User user = userRepository.findByName(request.getName())
                // Don't leak which part failed; treat as invalid credentials.
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));

        if (user.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User password is null in database");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        return new LoginResponse("Login Successful", user.getName());
    }
}
