package br.com.fiap.lifeshare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.dto.UserDeleteDTO;
import br.com.fiap.lifeshare.dto.UserUpdateDTO;
import br.com.fiap.lifeshare.exception.UserAlreadyExistsException;
import br.com.fiap.lifeshare.exception.UserNotFoundException;
import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) throws UserAlreadyExistsException {
        if(userExist(userDTO.getEmail())) throw new UserAlreadyExistsException("Usuário já existe.");

        User user = userDTO.convert();
        encryptPassword(user);

        user = userRepository.save(user);
        return user.convert();
    }

    private boolean userExist(String email) {
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

    public void delete(UserDeleteDTO userDeleteDTO) throws UserNotFoundException {
        String email = userDeleteDTO.getEmail();
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()) throw new UserNotFoundException("Usuário não existe para ser atualizado");

        user.get().setStatus(false);

        userRepository.save(user.get());
    }
}
