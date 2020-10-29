package br.com.fiap.lifeshare.dto;

import javax.validation.constraints.NotBlank;

import br.com.fiap.lifeshare.model.Donation;
import br.com.fiap.lifeshare.utils.DateUtil;

public class DonationDTO {
    private Long id;
    private @NotBlank String type;
    private String organ;
    private @NotBlank String location;
    private @NotBlank String date;
    private @NotBlank String userEmail;

    public DonationDTO() {}

    public DonationDTO(Long id, String type, String organ, String location, String date) {
        this.id = id;
        this.type = type;
        this.organ = organ;
        this.location = location;
        this.date = date;
    }

    public Donation convert() {
		return new Donation(this.type, this.organ, this.location, DateUtil.stringToCalendar(this.date));
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrgan() {
        return this.organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
