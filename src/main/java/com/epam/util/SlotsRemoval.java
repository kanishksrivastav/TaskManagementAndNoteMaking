package com.epam.util;

import java.time.LocalDateTime;
import java.util.Iterator;

import com.epam.service.TaskServiceVariables;

public class SlotsRemoval implements TaskServiceVariables{
	public void removeSlot(LocalDateTime[] timeSlot) {
		LocalDateTime start = timeSlot[0];
		LocalDateTime end = timeSlot[1];
		Iterator<LocalDateTime[]> itr = dateTimeSlots.iterator();
		while(itr.hasNext()) {
			LocalDateTime[] tempTimeSlot = itr.next();
			LocalDateTime tempStart = tempTimeSlot[0];
			LocalDateTime tempEnd = tempTimeSlot[1];
			if(tempStart.equals(start) && tempEnd.equals(end)) {
				dateTimeSlots.remove(tempTimeSlot);
			}                      
		}                          
	}           
}
