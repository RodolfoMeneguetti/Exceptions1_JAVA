package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Estatico para nao instanciar outro sdf em outra aplicação" 

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void updateDates(Date checkIn, Date checkOut) {
		this.checkin = checkIn;
		this.checkOut = checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", check-in" + sdf.format(checkin) + ", check-out" + sdf.format(checkOut) + ", "
				+ duration() + " nights";

	}

}
