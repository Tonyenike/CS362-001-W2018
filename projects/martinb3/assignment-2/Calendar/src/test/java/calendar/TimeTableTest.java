package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	// Check to see that the error handling for if firstday > lastday
	 @Test(expected=DateOutOfRangeException.class)
	  public void test01()  throws Throwable {
	
		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(today);
		
		TimeTable timetable = new TimeTable();
		timetable.getApptRange(aDay.getAppts(), today, yesterday);
		 
	 }

	// Check to see that we DON'T get an error for if firstday < lastday. If there is an error, the test will report it.
	 @Test
	  public void test02()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(today);
		
		TimeTable timetable = new TimeTable();
		timetable.getApptRange(aDay.getAppts(), yesterday, today);
	 }
	

	//Check to see that the getApptRange function is operable with appts added.
	@Test
	public void test03() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(today);


		 int startHour=21;
		 int startMinute=30;
		 int startDay=1;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 5;
		startMinute = 45;
		title = "Something Else";
		description = "Have to read the newspaper.";
		//Construct another appointment.
		Appt crappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 16;
		startMinute = 35;
		title = "Oh dear";
		description = "Not another appt!";
		//Construct another appointment.
		Appt crapple = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		aDay.addAppt(appt);
		aDay.addAppt(crappt);
		aDay.addAppt(crapple);


		
		TimeTable timetable = new TimeTable();
		timetable.getApptRange(aDay.getAppts(), yesterday, today);

	// Now we add an invalid appt.
		startHour = 200;
		startMinute = 35;
		title = "Invalid appt";
		description = "Not another appt!";
		//Construct another appointment.
		Appt trapple = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);


		int [] doy = new int[2];
		doy[0] = 5;
		doy[1] = 6;

		trapple.setRecurrence(doy, 1, 1, 1);

		LinkedList<Appt> huh = new LinkedList<Appt>();
		huh.add(trapple);
		timetable.getApptRange(huh, yesterday, today);


	}
	// Check to see that we can remove an appt and that it is equal to the one less appt.
	@Test
	public void test04() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(today);
		CalDay bDay = new CalDay(today);


		 int startHour=21;
		 int startMinute=30;
		 int startDay=1;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 5;
		startMinute = 45;
		title = "Something Else";
		description = "Have to read the newspaper.";
		//Construct another appointment.
		Appt crappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 16;
		startMinute = 35;
		title = "Oh dear";
		description = "Not another appt!";
		//Construct another appointment.
		Appt crapple = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		aDay.addAppt(appt);
		aDay.addAppt(crappt);
		aDay.addAppt(crapple);

		
		TimeTable timetable = new TimeTable();
		timetable.deleteAppt(aDay.getAppts(), crappt);
		
		startHour = 300;
		startMinute = 35;
		title = "Running to the graveyard";
		description = "very fast!";
		Appt notValid = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		startHour = 3;
		startMinute = 18;
		title = "This one doesn't exist";
		description = "At all!";
		Appt noExist = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		
		timetable.deleteAppt(aDay.getAppts(), notValid);
		timetable.deleteAppt(aDay.getAppts(), noExist); 
		timetable.deleteAppt(aDay.getAppts(), null);
		timetable.deleteAppt(null, crapple);
	}


	// Test for recurring appointments now.
	

	@Test
	public void test05() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2010, 1, 1);
		GregorianCalendar wayday = new GregorianCalendar(2020, 1, 1);
		
		CalDay aDay = new CalDay(today);
		CalDay bDay = new CalDay(today);


		 int startHour=21;
		 int startMinute=30;
		 int startDay=1;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 5;
		startMinute = 45;
		title = "Something Else";
		description = "Have to read the newspaper.";
		//Construct another appointment.
		Appt crappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 16;
		startMinute = 35;
		title = "Oh dear";
		description = "Not another appt!";
		//Construct another appointment.
		Appt crapple = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 startHour=11;
		 startMinute=40;
		 startDay=1;
		 startMonth=02;
		 startYear=2018;
		 title="Birthday Par";
		 description="Going Golfing on the birthday.";
		 //Construct a new Appointment object with the initial data	 
		 Appt lappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 startHour=10;
		 startMinute=43;
		 startDay=1;
		 startMonth=02;
		 startYear=2018;
		 title="Birthday Pat";
		 description="Going Barking on the birthday.";
		 //Construct a new Appointment object with the initial data	 
		 Appt mappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 
		 startHour=1;
		 startMinute=43;
		 startDay=12;
		 startMonth=02;
		 startYear=2018;
		 title="Birthday Pat";
		 description="Going Barking on the birthday.";
		 //Construct a new Appointment object with the initial data	 
		 Appt trappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		int [] recurDays = new int[3];
		recurDays[0] = 1;
		recurDays[1] = 2;
		recurDays[2] = 3;

		int recurNumber = 1;
		int recurBy = 6;
		int recurIncrement = 3;

		crappt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		
		recurDays = new int[0];

		recurNumber = 1;
		recurBy = 1;
		recurIncrement = 1;


		appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);


		recurDays = new int[2];
		recurDays[0] = -1;
		recurDays[1] = 1;
		recurBy = 100;
		recurNumber = 1000;
		recurIncrement = 1;
		
		crapple.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
	

		recurDays = new int[2];
		recurDays[0] = 99;
		recurDays[1] = 98;
		recurBy = 100;
		recurNumber = 1;
		recurIncrement = 1;
		int [] something = new int[2];
		something[0] = 6;
		something[1] = 5;
		
		lappt.setRecurrence(something, recurBy, recurIncrement, recurNumber);
		
		recurDays = new int[2];
		recurDays[0] = 4;
		recurDays[1] = 5;
		recurBy = 2050;
		recurNumber = 3;
		recurIncrement = 2;
		
		mappt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		
		recurDays = new int[5];
		recurDays[0] = 7;
		recurDays[1] = 6;
		recurDays[2] = 6;
		recurDays[3] = 6;
		recurDays[4] = 6;
		recurBy = 100;
		recurNumber = 4;
		recurIncrement = 4;
		
		trappt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		
	
	
		LinkedList<Appt> thingy = new LinkedList<Appt>();
		thingy.add(appt);
		thingy.add(crappt);
		thingy.add(crapple);
		thingy.add(lappt);
		thingy.add(mappt);
		thingy.add(trappt);

		aDay.addAppt(crappt);

		TimeTable timetable = new TimeTable();
		timetable.getApptRange(thingy, yesterday, today);
		timetable.getApptRange(thingy, yesterday, wayday);
		timetable.getApptRange(aDay.getAppts(), yesterday, wayday);

	}
	@Test
	public void test06() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2010, 1, 1);
		GregorianCalendar wayday = new GregorianCalendar(2020, 1, 1);
		
		CalDay aDay = new CalDay(today);

		int startMonth = 2;
		int startYear = 2018;
		int startDay = 5;
		int startHour = 5;
		int startMinute = 45;
		String title = "Something Else";
		String description = "Have to read the newspaper.";
		//Construct another appointment.
		Appt crappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		int [] recurDays = new int[3];
		recurDays[0] = 1;
		recurDays[1] = 2;
		recurDays[2] = 3;

		int recurNumber = 1;
		int recurBy = 6;
		int recurIncrement = 3;

		crappt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		


		aDay.addAppt(crappt);

		TimeTable timetable = new TimeTable();
		timetable.getApptRange(aDay.getAppts(), yesterday, wayday);



	}

	// Using the permute function


	@Test
	public void test07() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(today);
		CalDay bDay = new CalDay(today);


		 int startHour=21;
		 int startMinute=30;
		 int startDay=1;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 5;
		startMinute = 45;
		title = "Something Else";
		description = "Have to read the newspaper.";
		//Construct another appointment.
		Appt crappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 16;
		startMinute = 35;
		title = "Oh dear";
		description = "Not another appt!";
		//Construct another appointment.
		Appt crapple = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		aDay.addAppt(appt);
		aDay.addAppt(crappt);
		aDay.addAppt(crapple);

		TimeTable timetable = new TimeTable();
		int [] bruh = new int[3];
		bruh[0] = 2;
		bruh[1] = 1;
		bruh[2] = 0;
		timetable.permute(aDay.getAppts(), bruh);



	}

	// Test the permute function where the number of elements is incorrect.
	
	@Test(expected=IllegalArgumentException.class)
	public void test08() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(today);
		CalDay bDay = new CalDay(today);


		 int startHour=21;
		 int startMinute=30;
		 int startDay=1;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 5;
		startMinute = 45;
		title = "Something Else";
		description = "Have to read the newspaper.";
		//Construct another appointment.
		Appt crappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		startHour = 16;
		startMinute = 35;
		title = "Oh dear";
		description = "Not another appt!";
		//Construct another appointment.
		Appt crapple = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		aDay.addAppt(appt);
		aDay.addAppt(crappt);
		aDay.addAppt(crapple);

		TimeTable timetable = new TimeTable();
		int [] bruh = new int[4];
		bruh[0] = 2;
		bruh[1] = 1;
		bruh[2] = 0;
		bruh[3] = 4;
		timetable.permute(aDay.getAppts(), bruh);
	}

//add more unit tests as you needed
}
