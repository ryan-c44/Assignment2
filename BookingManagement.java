package assignment2;

import java.util.*;

public class BookingManagement {
	
	private ArrayList<BookingRecord> bookings = new ArrayList<BookingRecord>(); 

	public BookingManagement() {
		
	}
	
	public boolean addBookingRecord(BookingRecord booking) {
		return bookings.add(booking);
	}
	
	public ArrayList<BookingRecord> findBookingRecordByUsername(String username) {
		for(BookingRecord booking : bookings) {
			if(booking.getUser().getUsername().equals(username)) {
				return bookings;
			}
		}
		return null;
	}
	
}
