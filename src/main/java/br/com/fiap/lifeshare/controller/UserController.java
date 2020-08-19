package br.com.fiap.lifeshare.controller;

import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
        try {
            User user = userDTO.convert();
            user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
            userRepository.save(user);
            return new ResponseEntity<>("Usuario criado", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Usuario não pode ser criado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> read(){
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            userDTOS.add(user.convert());
        }
        return new ResponseEntity<List<UserDTO>>(userDTOS, HttpStatus.OK);
    }
}
