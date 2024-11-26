package hms.generic.fileutlity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	//Random number
	public int getRandomNumber() {
		Random random=new Random();
		int randomNumber=random.nextInt(5000);
		return randomNumber;
	}
	
	//System currentdata
	public String getSystemDateYYYYDDMM() {
		Date date=new Date();
		sim=new SimpleDateFormat("yyyy-MM-dd");
		String data = sim.format(date);
		return data;
	}
	
	//Get required date(after/before)
	public String getRequriedDateYYYYDDMM(int days) {
		Calendar cal = sim.getCalendar();
        cal.add(Calendar.DAY_OF_MONTH, days);
       String reqDate = sim.format(cal.getTime());
       return reqDate;
	}
	
}
