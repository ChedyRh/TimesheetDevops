package tn.esprit.spring.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Appointment;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	@Query("SELECT a FROM Appointment a WHERE a.state=:confirmed ")
	List<Appointment> retrieveAllAppointmentByState(@Param("confirmed")String State);
	
	@Query("SELECT a FROM Appointment a WHERE a.dateAppointement=:date ")
	Appointment findByDate(@Param("date")Date date);
}
