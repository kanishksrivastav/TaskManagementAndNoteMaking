package com.epam.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import com.epam.constants.Constants;
import com.epam.model.Task;

class TaskTest {
	
	Task taskMocked;
	protected final static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(Constants.DATETIME_PATTERN);
	@BeforeEach
	void setup() {
		taskMocked=mock(Task.class);
	}
	
	@Test
	void getTaskTitleTest() {
		String title="Breakfast";
		when(taskMocked.getTaskTitle()).thenReturn(title);
		assertEquals("Breakfast",taskMocked.getTaskTitle());
		verify(taskMocked,atMostOnce()).getTaskTitle();
	}
	@Test 
	void setTaskTitleTest(){
		taskMocked.setTaskTitle(ArgumentMatchers.anyString());
		verify(taskMocked,atMostOnce()).setTaskTitle(ArgumentMatchers.anyString());
	}
	@Test
	void getTaskStartDateTimeTest() {
		LocalDateTime startDateTime=LocalDateTime.parse("07/07/2021 10:00", dateTimeFormat);
		when(taskMocked.getTaskStartDateTime()).thenReturn(startDateTime);
		assertEquals(LocalDateTime.parse("07/07/2021 10:00", dateTimeFormat),taskMocked.getTaskStartDateTime());
		verify(taskMocked,atMostOnce()).getTaskStartDateTime();
	}
	@Test
	void setTaskStartDateTimeTest(){
		taskMocked.setTaskStartDateTime(ArgumentMatchers.any());
		verify(taskMocked,atMostOnce()).setTaskStartDateTime(ArgumentMatchers.any());
	}
	@Test
	void getTaskEndDateTimeTest() {
		LocalDateTime endDateTime=LocalDateTime.parse("07/07/2021 12:00", dateTimeFormat);
		when(taskMocked.getTaskEndDateTime()).thenReturn(endDateTime);
		assertEquals(LocalDateTime.parse("07/07/2021 12:00", dateTimeFormat),taskMocked.getTaskEndDateTime());
		verify(taskMocked,atMostOnce()).getTaskEndDateTime();
	}
	@Test
	void setTaskEndDateTimeTest(){
		taskMocked.setTaskEndDateTime(ArgumentMatchers.any());
		verify(taskMocked,atMostOnce()).setTaskEndDateTime(ArgumentMatchers.any());
	}
	@Test
	void getTaskStatusTest() {
		String status="Active";
		when(taskMocked.getTaskStatus()).thenReturn(status);
		assertEquals("Active",taskMocked.getTaskStatus());
		verify(taskMocked,atMostOnce()).getTaskStatus();
	}
	@Test 
	void setTaskStatusTest(){
		taskMocked.setTaskStatus(ArgumentMatchers.anyString());
		verify(taskMocked,atMostOnce()).setTaskStatus(ArgumentMatchers.anyString());
	}
}
