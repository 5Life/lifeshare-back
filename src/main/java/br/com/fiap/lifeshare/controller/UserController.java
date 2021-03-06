package br.com.fiap.lifeshare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lifeshare.dto.ResponseDTO;
import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.dto.UserDeleteDTO;
import br.com.fiap.lifeshare.dto.UserUpdateDTO;
import br.com.fiap.lifeshare.exception.UserAlreadyExistsException;
import br.com.fiap.lifeshare.exception.UserNotFoundException;
import br.com.fiap.lifeshare.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody UserDTO userDTO) {
        try {
            return new ResponseEntity<>(
                new ResponseDTO(
                        "Usuário criado com sucesso.", userService.create(userDTO)
                ), HttpStatus.CREATED
            );
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody UserUpdateDTO userUpdateDTO) {
        try {
            return new ResponseEntity<>(
                new ResponseDTO(
                        "Usuário atualizado com sucesso.", userService.update(userUpdateDTO)
                ), HttpStatus.OK
            );
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<ResponseDTO> delete(@Valid @RequestBody UserDeleteDTO userDeleteDTO) {
        try {
            userService.delete(userDeleteDTO);
            
            return new ResponseEntity<>(
                new ResponseDTO("Usuário deletado com sucesso.", null), HttpStatus.OK
            );
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
