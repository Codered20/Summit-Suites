package com.summit_suites.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Booked_Rooms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	
	@Column(name = "CheckIn")
	private LocalDate checkInDate;
	
	@Column(name = "CheckOut")
	private LocalDate checkOutDate;
	
	@Column(name = "GuestFullName")
	private String guestFullName;
	
	@Column(name = "GuestEmail")
	private String guestEmail;
	
	@Column(name = "Adults")
	private int numOfAdults;
	
	@Column(name = "Children")
	private int numOfChildren;
	
	@Column(name = "TotalGuest")
	private int totalNumOfGuest;
	
	@Column(name = "BookingConfirmationCode")
	private String bookingConfirmationCode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "RoomId")
	private Room room;
	
	public void calculateTotalNumOfGuests() {
		this.totalNumOfGuest= this.numOfAdults+this.numOfChildren;
	}

	public int getNumOfAdults() {
		return numOfAdults;
	}

	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
		calculateTotalNumOfGuests();
	}

	public int getNumOfChildren() {
		return numOfChildren;
	}

	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
		calculateTotalNumOfGuests();
	}

	public String getBookingConfirmationCode() {
		return bookingConfirmationCode;
	}

	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		this.bookingConfirmationCode = bookingConfirmationCode;
	}

	public void setRoom(Room room) {
		// TODO Auto-generated method stub
		this.room = room;		
	}
	
}
