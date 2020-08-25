package br.com.fiap.lifeshare.service;

import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        User user = userDTO.convert();
        user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
        user = userRepository.save(user);
        return user.convert();
    }

    public List<UserDTO> read() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            userDTOS.add(user.convert());
        }
        return userDTOS;
    }
}
