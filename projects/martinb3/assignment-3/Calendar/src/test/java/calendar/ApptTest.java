package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	/*
 	 * Test that the set methods work as expected as well, if it can and will change our appt data.
 	 */ 

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=5;
		 int startMinute=25;
		 int startDay=7;
		 int startMonth=02;
		 int startYear=2018;
		 String title="Going to the dump";
		 String description="Dumping off crap";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
			startMinute,
			startDay,
			startMonth,
			startYear,
			title,
			description);	
		 // Now we are going to change all the days and times, see if set works properly.
		 appt.setStartHour(8);
		 appt.setStartMinute(45);
		 appt.setStartDay(19);
		 appt.setStartMonth(03);
		 appt.setStartYear(2020);
		 appt.setTitle("Going to the recycling center");
		 appt.setDescription("Being economical");
		// assertions
		assertTrue(appt.getValid());
		 assertEquals(8, appt.getStartHour());
		 assertEquals(45, appt.getStartMinute());
		 assertEquals(19, appt.getStartDay());
		 assertEquals(03, appt.getStartMonth());
		 assertEquals(2020, appt.getStartYear());
		 assertEquals("Going to the recycling center", appt.getTitle());
		 assertEquals("Being economical", appt.getDescription());         		
	 }
    
	/*
 	*  Checking to see if we can implement recursion, and then checks that the get functions work.
 	*/ 

	@Test
	public void test03() throws Throwable {
		int recurDays[] = new int[3];
		recurDays[0] = 1;
		recurDays[1] = 2;
		recurDays[2] = 3;
		int recurBy = 2;
		int recurIncrement = 15;
		int recurNumber = 1;
		 
		 int startHour=5;
		 int startMinute=25;
		 int startDay=7;
		 int startMonth=02;
		 int startYear=2018;
		 String title="Going to the dump";
		 String description="Dumping off crap";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
			startMinute,
			startDay,
			startMonth,
			startYear,
			title,
			description);
		 //Set our recurrance.	
 		 appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		 //Assertions
		 assertEquals(recurBy, appt.getRecurBy());
		 assertEquals(recurIncrement, appt.getRecurIncrement());
		 assertEquals(recurDays, appt.getRecurDays());
		 assertEquals(recurNumber, appt.getRecurNumber());
		 assertTrue(appt.isRecurring());
		
		// Check to see if isRecurring is set to false if recurNumber is set to 0.
		appt.setRecurrence(recurDays, recurBy, recurIncrement, 0);
		assertFalse(appt.isRecurring());
	}
	
	/*
 	*  Tests 4 - 7 to ensure that setting invalid times and days results in invalid appts.
 	*/ 


	@Test
	public void test04() throws Throwable {
		 int startHour=24; // This is an invalid hour
		 int startMinute=0;
		 int startDay=1;
		 int startMonth=12;
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
		// assertions
		assertFalse(appt.getValid());
		startHour = -1; // This is also invalid; it is too low.
		appt.setStartHour(startHour);
		assertFalse(appt.getValid());
		startHour = 8; // This is valid.
		appt.setStartHour(startHour);
		assertTrue(appt.getValid());
	}

	@Test
	public void test05() throws Throwable {
		 int startHour=23;
		 int startMinute=60; // This is an invalid minute
		 int startDay=31;
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
		// assertions
		 assertFalse(appt.getValid());
		startMinute = -1; // This is also invalid; it is too low.
		appt.setStartMinute(startMinute);
		assertFalse(appt.getValid());
		startMinute = 45; // This is valid.
		appt.setStartMinute(startMinute);
		assertTrue(appt.getValid());
	}
	
	@Test
	public void test06() throws Throwable {
		 int startHour=0;
		 int startMinute=59;
		 int startDay=32; // This is an invalid day
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
		// assertions
		assertFalse(appt.getValid());
		startDay = 0; // This is also invalid; it is too low.
		appt.setStartDay(startDay);
		assertFalse(appt.getValid());
		startDay = 10; // This is valid.
		appt.setStartDay(startDay);
		assertTrue(appt.getValid());
	}
		 
	@Test
	public void test07() throws Throwable {
		 int startHour=23;
		 int startMinute=0;
		 int startDay=31;
		 int startMonth=12; // This is an valid month
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
		// assertions
		assertTrue(appt.getValid());
		//appt.setStartMonth(-10);
		//assertFalse(appt.getValid());
	}
	
	/*
 	*  Testing to see that the toString function returns null for an invalid appointment, and that it does not do so when the appointment is valid.
 	*/ 	

	 
	@Test
	public void test08() throws Throwable {


		 int startHour=25; // This is an invalid hour
		 int startMinute=30;
		 int startDay=15;
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
		 // assertions

		 //Now the string should NOT be null, since the appt is now valid.
		 appt.setStartHour(21);
		 assertNotEquals(null,appt.toString());

		 
		//Checking for more branch coverage for when hour < 12
		 appt.setStartHour(9);
		 assertNotEquals(null,appt.toString());

		 // IF the appointment is invalid (which it is), then it should return null.
		appt.setStartHour(25); 
		assertEquals(null, appt.toString());

	}
		
	@Test
	public void test09() throws Throwable {


		 int startHour=12;
		 int startMinute=30;
		 int startDay=15;
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
		 // assertions



		String check = appt.getStartMonth() 
				+ "/" + appt.getStartDay() 
				+ "/"+appt.getStartYear() + " at ";


		String half = (appt.getStartHour() > 11) ? "pm" : "am";
		int printableHour = appt.getStartHour();
		if (printableHour > 11){
 			printableHour -= 12;
 		}
		if (printableHour == 0){
			printableHour = 12;
		}
		String tester= printableHour +":"+ appt.getStartMinute() + half;

		String full = "\t" + check + tester + " ," + appt.getTitle() + ", " + appt.getDescription() + "\n";

		assertEquals(full, appt.toString());
		


	}
	

	@Test
	public void test10() throws Throwable {


		 int startHour=11;
		 int startMinute=30;
		 int startDay=15;
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
		 // assertions



		String check = appt.getStartMonth() 
				+ "/" + appt.getStartDay() 
				+ "/"+appt.getStartYear() + " at ";


		String half = (appt.getStartHour() > 11) ? "pm" : "am";
		int printableHour = appt.getStartHour();
		if (printableHour > 11){
 			printableHour -= 12;
 		}
		if (printableHour == 0){
			printableHour = 12;
		}
		String tester= printableHour +":"+ appt.getStartMinute() + half;

		String full = "\t" + check + tester + " ," + appt.getTitle() + ", " + appt.getDescription() + "\n";

		assertEquals(full, appt.toString());
		


	}
 
	@Test
	public void test11() throws Throwable {


		 int startHour=0; // This is an invalid hour
		 int startMinute=30;
		 int startDay=15;
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
		 // assertions



		String check = appt.getStartMonth() 
				+ "/" + appt.getStartDay() 
				+ "/"+appt.getStartYear() + " at ";


		String half = (appt.getStartHour() > 11) ? "pm" : "am";
		int printableHour = appt.getStartHour();
		if (printableHour > 11){
 			printableHour -= 12;
 		}
		if (printableHour == 0){
			printableHour = 12;
		}
		String tester= printableHour +":"+ appt.getStartMinute() + half;

		String full = "\t" + check + tester + " ," + appt.getTitle() + ", " + appt.getDescription() + "\n";

		assertEquals(full, appt.toString());
		


	}
 
	@Test
	public void test12() throws Throwable {


		 int startHour=3;
		 int startMinute=30;
		 int startDay=15;
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

		 startHour=6;
		 startMinute=35;
		 startDay=14;
		 startMonth=03;
		 startYear=2020;
		 title="Birthd Part";
		 description="Fake news.";
		 //Construct a new Appointment object with the initial data	 
		 Appt bappt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 // assertions

	
		int total;
		int minute = appt.getStartMinute() - bappt.getStartMinute();
		int hour = appt.getStartHour() - bappt.getStartHour();
		int day = appt.getStartDay() - bappt.getStartDay();
		int month = appt.getStartMonth() - bappt.getStartMonth();
		int year = appt.getStartYear() - bappt.getStartYear();

		total = minute + hour + day + month + year;
		assertEquals(total, appt.compareTo(bappt));



	}
 
//add more unit tests as you needed
	
}
