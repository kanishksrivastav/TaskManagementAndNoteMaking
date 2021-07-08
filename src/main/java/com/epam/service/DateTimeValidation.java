package com.epam.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DateTimeValidation {

	private static List<LocalDateTime[]> dateTimeSlots = new ArrayList<LocalDateTime[]>();
	public static boolean isDateTimeValid(LocalDateTime start, LocalDateTime end) {
		if( end.compareTo(start) > 0) {
			return true;
		}
		return false;
	}
	public static boolean isDateTimeNotConflicting(LocalDateTime[] timeSlot) {
		if(dateTimeSlots.isEmpty()) {
			dateTimeSlots.add(timeSlot);
			return true;
		}
		LocalDateTime start = timeSlot[0];
		LocalDateTime end = timeSlot[1];
		Iterator<LocalDateTime[]> itr = dateTimeSlots.iterator();
		while(itr.hasNext()) {
			LocalDateTime[] tempTimeSlot = itr.next();
			LocalDateTime tempStart = tempTimeSlot[0];
			LocalDateTime tempEnd = tempTimeSlot[1];
			if(!( (start.isAfter(tempStart) && end.isAfter(tempEnd)) || 
					(start.isBefore(tempStart) && end.isBefore(tempEnd)) )) {
				return false;
			}
		}
		dateTimeSlots.add(timeSlot);
		return true;
	}
}
