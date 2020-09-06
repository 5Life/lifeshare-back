package br.com.fiap.lifeshare.service;

import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.dto.UserUpdateDTO;
import br.com.fiap.lifeshare.exception.UserNotFoundException;
import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) throws UserNotFoundException {
        if(userExist(userDTO.getEmail())) throw new UserNotFoundException("Usuário já foi criado");

        User user = userDTO.convert();
        encryptPassword(user);

        user = userRepository.save(user);
        return user.convert();
    }

    private Boolean userExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }

    private void encryptPassword(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    }

    public UserUpdateDTO update(UserUpdateDTO userUpdateDTO) throws UserNotFoundException {
        Optional<User> user = userRepository.findByEmail(userUpdateDTO.getEmail());
        if(user.isEmpty()) throw new UserNotFoundException("Usuário não existe para ser atualizado");

        user.get().setBloodGroup(userUpdateDTO.getBloodGroup());
        user.get().setName(userUpdateDTO.getName());

        User newUser = userRepository.save(user.get());
        return newUser.convertToUserUpdate();
    }
}
