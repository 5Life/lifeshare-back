package br.com.fiap.lifeshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lifeshare.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {}
