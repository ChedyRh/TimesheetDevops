package tn.esprit.spring.entreprise.tests;

import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.controller.RestControlTimesheet;
import tn.esprit.spring.entities.Mission;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimesheetTest {
	  @Autowired
	    RestControlTimesheet controllerTimesheet;
	   @Test
	    public void testAjouterMission(){

	        Mission mission=new Mission("formation","Formation Angular");
	        controllerTimesheet.ajouterMission(mission);


	    }
	   @Test
	    public void testAffectrMission(){

	        controllerTimesheet.affecterMissionADepartement(25, 5);


	    }
	   @Test
	    public void testajouterTimesheet(){

		  Date  dateTime = new Date( "08/07/2019" );
	        controllerTimesheet.ajouterTimesheet(25, 6,dateTime,dateTime);


	    }
	/*  @Test
	    public void testvaliderTimesheet(){
		   
		   Date  dateTime = new Date( "08/07/2019" );
		   Employe emp=new Employe("salmene","rabhi","salmene@gmail.com",true,Role.ADMINISTRATEUR);
	        controllerTimesheet.validerTimesheet(25, 9, dateTime, dateTime, emp.getId());
	    }*/
	   @Test
	    public void testfindAllMissionByEmployeJPQL(){

	      
	        controllerTimesheet.findAllMissionByEmployeJPQL(50);


	    }
	   @Test
	    public void testgetAllEmployeByMission(){

	        controllerTimesheet.getAllEmployeByMission(10);


	    }
}