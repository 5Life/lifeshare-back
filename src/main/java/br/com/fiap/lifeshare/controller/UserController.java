package br.com.fiap.lifeshare.controller;

import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.UserRepository;
import br.com.fiap.lifeshare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
        try {
            return new ResponseEntity<>(userService.create(userDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Usuario não pode ser criado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> read(){
        return new ResponseEntity<>(userService.read(), HttpStatus.OK);
    }
}
