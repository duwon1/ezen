package days13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class R {
	
	public static void main(String[] args) throws ParseException {
		
		Date today =new Date();
		System.out.println(today);
		
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(sdf1.format(today));

		Calendar cal =Calendar.getInstance();
		Date day=cal.getTime();
		
		sdf1=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf1.format(day));
		
		String strDate = sdf1.format(day)+"";
		String strDate1 = String.valueOf(sdf1.format(day));
		
		String strDate2="2023-02-24";
		sdf1=new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf1.parse(strDate2);
		
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy.MM.dd");
		System.out.println(sdf2.format(newDate));
}
}
