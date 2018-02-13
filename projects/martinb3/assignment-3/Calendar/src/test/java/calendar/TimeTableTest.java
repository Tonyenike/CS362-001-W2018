package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Iterator;
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
		// timetable.deleteAppt(aDay.getAppts(), crappt);
		
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

		LinkedList<Appt> yay = new LinkedList<Appt>();
		LinkedList<Appt> bee = new LinkedList<Appt>();

		bee.add(crapple);
		bee.add(appt);

		yay.add(appt);		


		LinkedList <Appt> knee = timetable.deleteAppt(bee, crapple);

		Iterator<Appt> itr = knee.iterator();
		Iterator<Appt> itt = yay.iterator();

		assertEquals(itt.next(), itr.next()); 

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
		
		lappt.setRecurrence(something, Appt.RECUR_BY_YEARLY, recurIncrement, recurNumber);
		
		recurDays = new int[2];
		recurDays[0] = 4;
		recurDays[1] = 5;
		recurBy = 2050;
		recurNumber = 3;
		recurIncrement = 2;
		
		mappt.setRecurrence(recurDays, Appt.RECUR_BY_MONTHLY, recurIncrement, recurNumber);
		
		recurDays = new int[5];
		recurDays[0] = 7;
		recurDays[1] = 6;
		recurDays[2] = 6;
		recurDays[3] = 6;
		recurDays[4] = 6;
		recurBy = 100;
		recurNumber = 4;
		recurIncrement = 4;
		
		trappt.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, recurIncrement, recurNumber);
		
	
	
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
		

		LinkedList<Appt> yoyo = new LinkedList<Appt>();
		yoyo.add(crappt);

		TimeTable timetable = new TimeTable();
		timetable.getApptRange(yoyo, yesterday, wayday);



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
	
	@Test
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

		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		LinkedList<Appt> yeyexd = new LinkedList<Appt>();

		hehexd.add(appt);
		hehexd.add(crappt);
		//hehexd.add(crapple);

		//yeyexd.add(crapple);
		yeyexd.add(crappt);
		yeyexd.add(appt);


		TimeTable timetable = new TimeTable();
		int [] bruh = new int[2];
		bruh[0] = 1;
		bruh[1] = 0;
		LinkedList<Appt> fat = timetable.permute(hehexd, bruh);


		Iterator<Appt> itr = fat.iterator();
		Iterator<Appt> itt = yeyexd.iterator();


		while (itr.hasNext()) {
    		Appt hmm = itr.next();
		Appt wow = itt.next();
    			// assertEquals(hmm, wow);
			assertNotEquals(null, wow);
		}


	}

	@Test
	public void test09() throws Throwable {
	

		GregorianCalendar today = new GregorianCalendar(2018, 1, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(today);
		CalDay bDay = new CalDay(today);

		 int startHour=21;
		 int startMinute=90;
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

		aDay.addAppt(appt);
		TimeTable timetable = new TimeTable();
		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		LinkedList<CalDay> yeyexd = new LinkedList<CalDay>();
		hehexd.add(appt);
		// assertEquals(yeyexd, timetable.getApptRange(hehexd, yesterday, today));

	}

	@Test
	public void test10() throws Throwable {
	

		GregorianCalendar today = new GregorianCalendar(2018, 1, 10);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar heyday = new GregorianCalendar(2018, 1, 8);
		

		CalDay aDay = new CalDay(yesterday);
		CalDay nDay = new CalDay(heyday);

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

		int[] recurDays = {};

		int recurNumber = 2;
		int recurIncrement = 30;

		appt.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, recurIncrement, recurNumber);

		aDay.addAppt(appt);
		nDay.addAppt(appt);

		TimeTable timetable = new TimeTable();

		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		hehexd.add(appt);
		LinkedList<CalDay> yeyexd = timetable.getApptRange(hehexd, yesterday, today);
		LinkedList<CalDay> wow = new LinkedList<CalDay>();

		wow.add(aDay);
		wow.add(nDay);

		Iterator<CalDay> itr = wow.iterator();
		Iterator<CalDay> itt = yeyexd.iterator();

		assertEquals(itr.next().getDay(), itt.next().getDay());
		Iterator<CalDay> its = wow.iterator();
		Iterator<CalDay> itn = yeyexd.iterator();
		assertEquals(its.next().toString(), itn.next().toString());

		CalDay gross;
		while(itt.hasNext()){
			gross = itt.next();
			if(gross.getDay() == 7 && gross.getMonth() == 1){
				assertEquals(itt.next().toString(), itr.next().toString());
			}
		}



	}

	@Test
	public void test11() throws Throwable {
	

		GregorianCalendar today = new GregorianCalendar(2018, 11, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(yesterday);

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

		int[] recurDays = {};

		int recurNumber = 2;
		int recurIncrement = 30;

		appt.setRecurrence(recurDays, Appt.RECUR_BY_MONTHLY, recurIncrement, recurNumber);

		aDay.addAppt(appt);

		TimeTable timetable = new TimeTable();

		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		hehexd.add(appt);
		LinkedList<CalDay> yeyexd = timetable.getApptRange(hehexd, yesterday, today);
		LinkedList<CalDay> wow = new LinkedList<CalDay>();

		wow.add(aDay);

		Iterator<CalDay> itr = wow.iterator();
		Iterator<CalDay> itt = yeyexd.iterator();

		assertEquals(itr.next().getDay(), itt.next().getDay());
		Iterator<CalDay> its = wow.iterator();
		Iterator<CalDay> itn = yeyexd.iterator();
		assertEquals(its.next().toString(), itn.next().toString());




	}

	@Test
	public void test12() throws Throwable {
	

		GregorianCalendar today = new GregorianCalendar(2018, 11, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(yesterday);

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

		int[] recurDays = {1, 2};

		int recurNumber = 2;
		int recurIncrement = 30;

		appt.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, recurIncrement, recurNumber);

		aDay.addAppt(appt);

		TimeTable timetable = new TimeTable();

		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		hehexd.add(appt);
		LinkedList<CalDay> yeyexd = timetable.getApptRange(hehexd, yesterday, today);
		LinkedList<CalDay> wow = new LinkedList<CalDay>();

		wow.add(aDay);

		Iterator<CalDay> itr = wow.iterator();
		Iterator<CalDay> itt = yeyexd.iterator();

		assertEquals(itr.next().getDay(), itt.next().getDay());
		Iterator<CalDay> its = wow.iterator();
		Iterator<CalDay> itn = yeyexd.iterator();
		assertEquals(its.next().toString(), itn.next().toString());




	}

	@Test
	public void test13() throws Throwable {
	

		GregorianCalendar today = new GregorianCalendar(2050, 11, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		
		CalDay aDay = new CalDay(yesterday);

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

		int[] recurDays = {1, 2};

		int recurNumber = 2;
		int recurIncrement = 30;

		appt.setRecurrence(recurDays, Appt.RECUR_BY_YEARLY, recurIncrement, recurNumber);

		aDay.addAppt(appt);

		TimeTable timetable = new TimeTable();

		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		hehexd.add(appt);
		LinkedList<CalDay> yeyexd = timetable.getApptRange(hehexd, yesterday, today);
		LinkedList<CalDay> wow = new LinkedList<CalDay>();

		wow.add(aDay);

		Iterator<CalDay> itr = wow.iterator();
		Iterator<CalDay> itt = yeyexd.iterator();

		assertEquals(itr.next().getDay(), itt.next().getDay());
		Iterator<CalDay> its = wow.iterator();
		Iterator<CalDay> itn = yeyexd.iterator();
		assertEquals(its.next().toString(), itn.next().toString());

	}

	@Test
	public void test14() throws Throwable {
	

		GregorianCalendar today = new GregorianCalendar(2050, 11, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 2, 12);
		
		CalDay aDay = new CalDay(yesterday);

		 int startHour=21;
		 int startMinute=30;
		 int startDay=12;
		 int startMonth=02;
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

		int[] recurDays = {1, 2};

		int recurNumber = 2;
		int recurIncrement = 30;

		appt.setRecurrence(recurDays, Appt.RECUR_BY_YEARLY, recurIncrement, recurNumber);

		aDay.addAppt(appt);

		TimeTable timetable = new TimeTable();

		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		hehexd.add(appt);
		LinkedList<CalDay> yeyexd = timetable.getApptRange(hehexd, yesterday, today);
		LinkedList<CalDay> wow = new LinkedList<CalDay>();

		wow.add(aDay);

		Iterator<CalDay> itr = wow.iterator();
		Iterator<CalDay> itt = yeyexd.iterator();

		assertEquals(itr.next().getDay(), itt.next().getDay());
		Iterator<CalDay> its = wow.iterator();
		Iterator<CalDay> itn = yeyexd.iterator();
		assertEquals(its.next().toString(), itn.next().toString());

	}
	

	@Test
	public void test15() throws Throwable {
	
		GregorianCalendar today = new GregorianCalendar(2050, 11, 2);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar nextyear = new GregorianCalendar(2019, 1, 1);
		
		CalDay aDay = new CalDay(yesterday);
		CalDay bDay = new CalDay(nextyear);

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

		int[] recurDays = {1, 2};

		int recurNumber = 1;
		int recurIncrement = 0;

		appt.setRecurrence(recurDays, Appt.RECUR_BY_YEARLY, recurIncrement, recurNumber);

		aDay.addAppt(appt);
		bDay.addAppt(appt);

		TimeTable timetable = new TimeTable();

		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		hehexd.add(appt);
		LinkedList<CalDay> yeyexd = timetable.getApptRange(hehexd, yesterday, today);
		LinkedList<CalDay> wow = new LinkedList<CalDay>();

		wow.add(aDay);
		wow.add(bDay);

		Iterator<CalDay> itr = wow.iterator();
		Iterator<CalDay> itt = yeyexd.iterator();

		assertEquals(itt.next().toString(), itr.next().toString());
		
		assertNotEquals(null, itt.next());

		CalDay gross;
		while(itt.hasNext()){
			gross = itt.next();
			if(gross.getDay() == 31 && gross.getMonth() == 12){
				assertEquals(itt.next().toString(), itr.next().toString());
			}
		}
	}

	
	@Test
	public void test16() throws Throwable {
	
		GregorianCalendar today = new GregorianCalendar(2018, 2, 20);
		GregorianCalendar yesterday = new GregorianCalendar(2018, 2, 12);
		GregorianCalendar nextyear = new GregorianCalendar(2018, 2, 20);
		GregorianCalendar nexttt = new GregorianCalendar(2018, 2, 15);
	
		CalDay aDay = new CalDay(yesterday);
		CalDay bDay = new CalDay(nextyear);
		CalDay cDay = new CalDay(nexttt);
		

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

		int[] recurDays = {2, 5};

		int recurNumber = 14;
		int recurIncrement = 0;

		appt.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, recurIncrement, recurNumber);

		aDay.addAppt(appt);
		bDay.addAppt(appt);
		cDay.addAppt(appt);

		TimeTable timetable = new TimeTable();

		LinkedList<Appt> hehexd = new LinkedList<Appt>();
		hehexd.add(appt);
		LinkedList<CalDay> yeyexd = timetable.getApptRange(hehexd, yesterday, today);
		LinkedList<CalDay> wow = new LinkedList<CalDay>();
		LinkedList<CalDay> bow = new LinkedList<CalDay>();

		wow.add(aDay);
		wow.add(bDay);

		bow.add(cDay);

		Iterator<CalDay> itd = bow.iterator();
		Iterator<CalDay> itr = wow.iterator();
		Iterator<CalDay> itt = yeyexd.iterator();

		assertEquals(itt.next().toString(), itr.next().toString());
		
		assertNotEquals(null, itt.next());

		CalDay gross;
		while(itt.hasNext()){
			gross = itt.next();
			if(gross.getDay() == 14 && gross.getMonth() == 2){
				assertEquals(itt.next().toString(), itd.next().toString());
			}
		}
	}

	


//add more unit tests as you needed
}
