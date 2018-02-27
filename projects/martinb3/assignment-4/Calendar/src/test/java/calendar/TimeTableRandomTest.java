package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=10;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
        return methodArray[n] ; // return the method name 
        }

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				



				 int startHour=ValuesGenerator.getRandomIntBetween(random, -5, 30);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -5, 65);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -5, 35);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -3, 14);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2000, 2030);
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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("deleteAppt")){
		










						}
					   else if (methodName.equals("getApptRange")){
						LinkedList<Appt> huh = new LinkedList<Appt>();
						for(int mm = 0; mm < 10; mm++){
				 			startHour=ValuesGenerator.getRandomIntBetween(random, -1, 25);
				 			startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 61);
				 			startDay=ValuesGenerator.getRandomIntBetween(random, -1, 32);
				 			startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 12);
				 			startYear=ValuesGenerator.getRandomIntBetween(random, 2000, 2030);

							appt.setStartHour(startHour);
							appt.setStartMinute(startMinute);
							appt.setStartDay(startDay);
							appt.setStartMonth(startMonth);
							appt.setStartYear(startYear);


							huh.add(appt);
						
							}
							TimeTable table = new TimeTable();

				 			int someDay=ValuesGenerator.getRandomIntBetween(random, 1, 26);
				 			int someMonth=ValuesGenerator.getRandomIntBetween(random, 2, 11);
				 			int someYear=ValuesGenerator.getRandomIntBetween(random, 2000, 2015);
							GregorianCalendar aday = new GregorianCalendar(someYear, someMonth, someDay);
				 			someDay=ValuesGenerator.getRandomIntBetween(random, 1, 26);
				 			someMonth=ValuesGenerator.getRandomIntBetween(random, 2, 11);
				 			someYear=ValuesGenerator.getRandomIntBetween(random, 2016, 2030);
							GregorianCalendar bday = new GregorianCalendar(someYear, someMonth, someDay);

							table.getApptRange(huh, aday, bday);
						}				
				}
				
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%100)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }
}
