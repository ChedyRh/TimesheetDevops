package tn.esprit.spring.entreprise.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.controller.RestControlEntreprise;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntreprisesTests {
	private static final Logger l = Logger.getLogger(EntreprisesTests.class);
	

	private static Instant startedAt;
	
	@Autowired
	RestControlEntreprise entrepriseControl;
	
	@BeforeClass	
	  public static  void initStartingTime() {
		l.info("Appel avant tous les tests");
		startedAt = Instant.now();
		
	}
	

	@AfterClass	
	 public static  void showTestDuration() {
		l.info("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		// String ,long , on a passer a MessageFormat
		l.info(MessageFormat.format("Durée des tests : {0} ms", duration));
	}
	 
	 
	@Test
	public void testEntreprise() {
		l.info("*********** Debut tests  **************");
		Entreprise e = new Entreprise("nameEntreprise","Ghazela");
		
		Departement depRH = new Departement("RH");

		e.addDepartement(depRH);

		Entreprise testEntr  = entrepriseControl.ajouterEntreprise(e); 
		
Departement testDep = entrepriseControl.ajouterDepartement(depRH);
		
		entrepriseControl.affecterDepartementAEntreprise(testDep.getId(), testEntr.getId());
		
		List<String> departements = entrepriseControl.getAllDepartementsNamesByEntreprise(testEntr.getId());
		
		for (String departementName : departements) {
			l.info(departementName);
		}
		
		Entreprise entreprise = entrepriseControl.getEntrepriseById(testEntr.getId());
		l.info(entreprise);
		
		
		
		l.info("supp department ");
		entrepriseControl.deleteDepartementById(testDep.getId());
		
		l.info("supp entreprise ");
		entrepriseControl.deleteEntrepriseById(testEntr.getId());
		
		
		l.info("*********** Fin tests *********  ");
		
		
	}


/*
	@Test

	public void testGetEntrepriseById(){
		Entreprise e= entrepriseControl.getEntrepriseById(89);
		Assert.assertEquals(e.getId(),89);	
	}
	

	@Test

	public void testDeleteEntrepriseById(){
		entrepriseControl.deleteEntrepriseById(89);
		Assert.assertNull(entrepriseControl.getEntrepriseById(89));
	}

*/


}
