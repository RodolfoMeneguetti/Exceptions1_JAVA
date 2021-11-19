package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// Input date
		try {
				System.out.print("Room number: ");
				int number = sc.nextInt();
				System.out.print("Check-in date (DD/MM/YYYY): ");
				Date checkIn = sdf.parse(sc.next());
				System.out.print("Check-out date (DD/MM/YYYY): ");
				Date checkOut = sdf.parse(sc.next());
		
				Reservation reservation = new Reservation(number, checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
		
				System.out.println();
				System.out.println("Enter data update to update the reservation: ");
				System.out.print("Check-in date (DD/MM/YYYY): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("Check-out date (DD/MM/YYYY): ");
				checkOut = sdf.parse(sc.next());
		
				reservation.updateDates(checkIn, checkOut);
		
				System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e ) {
			System.out.println("Invalid date format! ");
		}
		catch(DomainException e){
			System.out.println("Error in reservation " + e.getMessage());
		}
		catch(RuntimeException e ) {
			System.out.println("Unexpected error! ");
		}
		finally {
			System.out.println("End System");
		}
		sc.close();
	}

}
