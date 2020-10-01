package com.capg.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class CompareDurationTime {

	public static void main(String[] args) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
	    
	    String dateStart = "11/03/14 09:29:58";
	    String dateStop = "11/03/14 09:33:43";

	    ZoneId zone = ZoneId.systemDefault();
	    ZonedDateTime startDateTime = LocalDateTime.parse(dateStart, formatter).atZone(zone);
	    ZonedDateTime endDateTime = LocalDateTime.parse(dateStop, formatter).atZone(zone);
	    
	    Duration diff = Duration.between(startDateTime, endDateTime);
	    
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
	}
	



}
/*
 * Note that Duration always counts a day as 24 hours. If you want to treat time anomalies like summer time
 *  transistions differently, solutions inlcude (1) use ChronoUnit.DAYS (2) Use Period (3) Use LocalDateTimeinstead 
 *  ofZonedDateTime` (may be considered a hack).

The code above works with Java 8 and with ThreeTen Backport, that backport of java.time to Java 6 and 7. 
From Java 9 it may be possible to write it a bit more nicely using the methods toHoursPart, toMinutesPart and 
toSecondsPart added there.
*/
