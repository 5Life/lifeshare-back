package br.com.fiap.lifeshare.controller;

import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.exception.UserNotFoundException;
import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.UserRepository;
import br.com.fiap.lifeshare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserDTO userDTO) {
        try {
            return new ResponseEntity<>(userService.create(userDTO), HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> read(){
        return new ResponseEntity<>(userService.read(), HttpStatus.OK);
    }
}
