package br.com.fiap.lifeshare.service;

import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.exception.UserNotFoundException;
import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) throws UserNotFoundException {
        User user = userDTO.convert();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            user = userRepository.save(user);
            return user.convert();
        } catch (IllegalArgumentException e){
            throw new UserNotFoundException("Usuário já foi criado");
        }
    }

    public List<UserDTO> read() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) return Collections.emptyList();

        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(user -> userDTOS.add(user.convert()));

        return userDTOS;
    }
}
