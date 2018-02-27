package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

import org.junit.Test;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=10;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"addAppt"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
   /**
     * Generate Random Tests that tests CalDay Class.
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
				
		 		CalDay aDay = new CalDay();

				GregorianCalendar today = new GregorianCalendar(2018, 3, 1);
				CalDay bDay = new CalDay(today);


				 int startHour=ValuesGenerator.getRandomIntBetween(random, 12, 14);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 58);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 2, 26);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 3, 10);
				 int startYear=ValuesGenerator.RandInt(random);
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

				Appt crappt = new Appt(8,
					 30,
					 5,
					 3,
					 2019,
					 "hehe",
					 "xd");

			for (int i = 0; i < NUM_TESTS; i++) {
						   bDay.addAppt(appt);
						   bDay.addAppt(crappt);
						   int another;
							for(int blah = 0; blah < 5; blah++){
								another = ValuesGenerator.getRandomIntBetween(random, 0, 25);
								crappt.setStartHour(another);
								bDay.addAppt(crappt);
							}				   
				}
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }
}
