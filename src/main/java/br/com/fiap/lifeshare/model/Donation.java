package br.com.fiap.lifeshare.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.fiap.lifeshare.dto.DonationDTO;
import br.com.fiap.lifeshare.utils.DateUtil;

@Entity
@Table(name="TB_DOACAO")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String organ;
    private String location;
    private Calendar date;

    @OneToOne
    private User user;

    public Donation() {}

    public Donation(String type, String organ, String location, Calendar date) {
        this.type = type;
        this.organ = organ;
        this.location = location;
        this.date = date;
    }

    public DonationDTO convert() {
		return new DonationDTO(this.id, this.type, this.organ, this.location, DateUtil.calendarToString(this.date));
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

    public Calendar getDate() {
        return this.date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
