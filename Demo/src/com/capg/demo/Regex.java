package com.capg.demo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Regex {

	public static void main(String[] args) {
	String name="t  ";
	
System.out.println(isValidShowName(name));
LocalDateTime a = LocalDateTime.of(2020,10,02,11, 00, 00);
LocalDateTime b = LocalDateTime.of(2020,10,02,14, 00, 00);
   System.out.println(isValidShowTime(a,b));
	}
	public static boolean isValidShowName(String showName) {
		boolean flag=false;
		
		flag=showName.matches("[A-Za-z ]{3,15}");
		    if(flag)
			return flag;
		    
		return flag;
}
	public static boolean isValidShowTime(LocalDateTime start,LocalDateTime end) {
		boolean flag=false;
		
		if(start.isBefore(end)) {
			
			System.out.println(end.compareTo(start));
		Duration diff=	Duration.between(start, end);
			   
		    if (diff.isZero()) {
		        System.out.println("0 minutes");
		    } else {
		        long days = diff.toDays();
		        if (days != 0) {
		            System.out.print("" + days + " days ");
		            diff = diff.minusDays(days);
		        }
		        long hours = diff.toHours();
		        if (hours != 0) {
		            System.out.print("" + hours + " hours ");
		            
//System.out.println(hours==3);
		            if(hours==3) {
		            	System.out.println("caluculated duration");
		            	return true;
		            	}
		            diff = diff.minusHours(hours);
		        }
		        long minutes = diff.toMinutes();
		        if (minutes != 0) {
		            System.out.print("" + minutes + " minutes ");
		            diff = diff.minusMinutes(minutes);
		        }
		        long seconds = diff.getSeconds();
		        if (seconds != 0) {
		            System.out.print("" + seconds + " seconds ");
		        }
		        System.out.println();
		    }
			return true;
			}
			
		
			return flag;
		
		
	}

	
}
