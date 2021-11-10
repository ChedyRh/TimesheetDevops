package tn.esprit.spring.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.repository.AppointmentRepository;


@RestController
@RequestMapping("/appointment")
public class RestAppointmentController {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	private static final Logger logger = Logger.getLogger(RestAppointmentController.class);



	// create get all appointments api.
	@GetMapping("/getAllAppointments")
	public List<Appointment> getAllAppointments() {

		try {
			logger.debug("Getting all appointments!!! ");
			appointmentRepository.findAll();
			logger.info("Success!!! ");

		} catch (Exception e) {
			logger.error("Error within getAllAppointments() method:" + e);
		} 

		return appointmentRepository.findAll();
	}

	// create appointment
	@PostMapping("/addAppointment")
	public Appointment addAppointment(@RequestBody Appointment appointment) {
		try {
			logger.debug("Adding an appointment!!! ");
			appointmentRepository.save(appointment);
			logger.info("l'ajout est terminé avec succés!!! ");

		} catch (Exception e) {
			logger.error("Error within addAppointment() method:" + e);
		} finally {
			logger.info("Succeed to add an appointment!!! ");
		}

		return appointment;
	}

	// get appointment by id
	@GetMapping("/appointments/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Long id)
			throws ResourceNotFoundException {
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id : " + id));
		return ResponseEntity.ok().body(appointment);
	}

	// update appointment
	@PutMapping("/updateAppointment/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable(value = "id") Long id,
			@RequestBody Appointment appointmentDetails) throws ResourceNotFoundException {
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id : " + id));

		appointment.setDateAppointement(appointmentDetails.getDateAppointement());
		appointment.setState(appointmentDetails.getState());

		final Appointment updatedappointment = appointmentRepository.save(appointment);
		return ResponseEntity.ok(updatedappointment);
	}

	// delete appointment
	@DeleteMapping("/deleteAppointment/{id}")
	public Map<String, Boolean> deleteAppointment(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id : " + id));

		appointmentRepository.delete(appointment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	// create filter by state appointments api.
	@GetMapping("/getAllAppointments/sortByState/{state}")
	public List<Appointment> sortByState(@PathVariable(value = "state") String state) {
		return appointmentRepository.retrieveAllAppointmentByState(state);
	}
	
	public static void main(String[] args) {
		RestAppointmentController r = new RestAppointmentController();
		System.out.println( r.getAllAppointments().toString());
	}

}
