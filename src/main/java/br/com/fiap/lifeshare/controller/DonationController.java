package br.com.fiap.lifeshare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lifeshare.dto.DonationDTO;
import br.com.fiap.lifeshare.dto.ResponseDTO;
import br.com.fiap.lifeshare.service.DonationService;

@RestController
@RequestMapping("/api/user/donation")
@CrossOrigin
public class DonationController {
    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody DonationDTO donationDTO) {
        try {
            donationDTO = donationService.create(donationDTO);

            return new ResponseEntity<>(
                new ResponseDTO(
                    "Doação criada com sucesso.", donationDTO.getId()), HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
