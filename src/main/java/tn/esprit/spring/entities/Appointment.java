package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//.

@Entity
@Table(name = "appointment")

public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////////////////////////

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdAppointement;

	@Temporal(TemporalType.DATE)
	private Date dateAppointement;

	private String state;


	public Long getIdAppointement() {
		return IdAppointement;
	}

	public void setIdAppointement(Long idAppointement) {
		IdAppointement = idAppointement;
	}

	public Date getDateAppointement() {
		return dateAppointement;
	}

	public void setDateAppointement(Date dateAppointement) {
		this.dateAppointement = dateAppointement;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Appointment [IdAppointement=" + IdAppointement + ", dateAppointement=" + dateAppointement + ", state="
				+ state + "]";
	}

	public Appointment(Long idAppointement, Date dateAppointement, String state) {
		super();
		IdAppointement = idAppointement;
		this.dateAppointement = dateAppointement;
		this.state = state;
	}

	public Appointment() {
		super();

	}

}

///////////////////////////////////////////////////////////////////////////////////////////////
