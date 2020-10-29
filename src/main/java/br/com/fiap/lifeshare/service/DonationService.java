package br.com.fiap.lifeshare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lifeshare.dto.DonationDTO;
import br.com.fiap.lifeshare.exception.UserNotFoundException;
import br.com.fiap.lifeshare.model.Donation;
import br.com.fiap.lifeshare.model.User;
import br.com.fiap.lifeshare.repository.DonationRepository;
import br.com.fiap.lifeshare.repository.UserRepository;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserRepository userRepository;

    public DonationDTO create(DonationDTO donationDTO) throws UserNotFoundException {
        Donation donation = donationDTO.convert();
        
        Optional<User> user = userRepository.findByEmail(donationDTO.getUserEmail());

        if(user.isEmpty()) throw new UserNotFoundException("Usuário não existe para vincular a doação");
        
        donation.setUser(user.get());
        donation = donationRepository.save(donation);

        donationDTO = donation.convert();

        return donationDTO;
    }
}
