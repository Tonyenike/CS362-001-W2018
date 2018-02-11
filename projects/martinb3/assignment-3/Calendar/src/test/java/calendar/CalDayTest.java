package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	// Test to see if an unitialized CalDay is not valid, and its get functions.

	 @Test
	  public void test01()  throws Throwable  {
		 CalDay aDay = new CalDay();
		// assertions
		 assertFalse(aDay.isValid());

		GregorianCalendar today = new GregorianCalendar(2018, 1, 1);
		CalDay bDay = new CalDay(today);
		// Check that bday is valid
		 assertTrue(bDay.isValid());

		assertEquals(2018, bDay.getYear());
		assertEquals(1, bDay.getMonth());
		assertEquals(1, bDay.getDay());

	// Testing null cases for the appt iterator.
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 CalDay aDay = new CalDay();
		// assertions
		// assertEquals(null, aDay.iterator());
		// assertEquals(0, aDay.getSizeAppts());

	}
	
	// Testing for adding an appt to an invalid CalDay	 

	@Test
	  public void test03()  throws Throwable  {
		 CalDay aDay = new CalDay();
	
		// Now we try to add an appt to an invalid CalDay...

		 int startHour=21;
		 int startMinute=30;
		 int startDay=1;
		 int startMonth=04;
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

		// aDay.addAppt(appt); //Add the appt.

		// assertions, should not have added the appt.
	 }

	 // Testing for adding a single appt to a VALID CalDay
	 @Test
	  public void test04()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 1);
		 CalDay aDay = new CalDay(today);
	
		// Now we try to add an appt...

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

		aDay.addAppt(appt); //Add the appt.

		// assertions, should now have an appt.
		assertNotEquals(null, aDay.iterator());
		assertEquals(1, aDay.getSizeAppts());
		}

	//Testing for when we are adding multiple appts, see if they are in order.
	 @Test
	  public void test05()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 1);
		 CalDay aDay = new CalDay(today);
	
		// Now we try to add an appt

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
		assertNotEquals(null, aDay.iterator());
		assertEquals(3, aDay.getSizeAppts());

	}

	// Try and add an invalid appointment to a valid CalDay

	@Test
	public void test06() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 1);
		 CalDay aDay = new CalDay(today);
	
		// Now we try to add an appt

		 int startHour=77; //This is an invalid hour
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
		aDay.addAppt(appt);
		// assertEquals(null, aDay.iterator());
		// assertEquals(0, aDay.getSizeAppts());
	}
	
	// Try and create a toString for an invalid CalDay

	@Test
	public void test07() throws Throwable {
		 CalDay aDay = new CalDay();
	
		//Since aDay is not valid, tostring should be empty as thingy is.
		// assertEquals(null, aDay.toString());

	}

	// Ensures that a string is being made for a valid CalDay.

	@Test
	public void test08() throws Throwable {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 1);
		 CalDay aDay = new CalDay(today);

		assertNotNull(aDay.toString());


		 int startHour=20;
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
		aDay.addAppt(appt);

		assertNotNull(aDay.toString());

	}

	 @Test
	  public void test09()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 1);
		 CalDay aDay = new CalDay(today);
	
		// Now we try to add an appt

		 int startHour=17;
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
		startHour = 15;
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
		assertNotEquals(null, aDay.iterator());
		assertEquals(3, aDay.getSizeAppts());

		LinkedList<Appt> doy = new LinkedList<Appt>();
		doy.add(crappt);
		doy.add(crapple);
		doy.add(appt);

		Iterator<?> itr = doy.iterator();
		Iterator<?> itt = aDay.iterator();

		while(itr.hasNext()){
			assertEquals(itr.next(), itt.next());
		}

		CalDay noval = new CalDay();
		assertEquals(null, noval.iterator());

	}

	 @Test
	  public void test10()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 1);
	
		StringBuilder sb = new StringBuilder();

		CalDay noval = new CalDay();
		assertEquals(sb.toString(), noval.toString());

	}

	//add more unit tests as you needed	
}
