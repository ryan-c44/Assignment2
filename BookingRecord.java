package assignment2;

import java.time.*;
import java.util.*;

public class BookingRecord {

	private User user;
	private Service service;
	private LocalDate bookingDate;
	private LocalDate endDate;
	private boolean status;
	
	public BookingRecord(User user, Service service) {
		this.user = user;
		this.service = service;
	}
	
	public BookingRecord(User user, Service service, LocalDate bookingDate, LocalDate endDate, boolean status) {
		this.user = user;
		this.service = service;
		this.bookingDate = bookingDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	public String getAttributeDescriptionForSavingToFile() {
		return "User, Service, Booking Date, End Date, Status";
	}

	public String getDataToSaveToFile() {
		return "BookingRecord [user=" + user + ", Service: " + service + ", Booking Date: " + bookingDate + ", End Date: "
				+ endDate + ", Status: " + status + "]";
	}
	
	public static ArrayList<BookingRecord> filterBookingRecordByUsername(ArrayList<BookingRecord> bookingList, String username) {
		ArrayList<BookingRecord> bookingRecords = new ArrayList<BookingRecord>();
		
		for(BookingRecord booking : bookingList) {
			if(booking.user.getUsername().equals(username)) {
				bookingRecords.add(booking);
			}
		}
		return bookingRecords;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "BookingRecord [user=" + user + ", service=" + service + ", bookingDate=" + bookingDate + ", endDate="
				+ endDate + ", status=" + status + "]";
	}
	
}
