package teamid9527.moviebooking.service;

import java.util.Set;

import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.entities.MovieItem;
import teamid9527.moviebooking.entities.Reservation;

public interface ReservationService {

	public Reservation queryReservation(Customer customer);

	public void updateReservation(Customer customer, Set movieItems);
	
	public void insertReservation(Customer customer, MovieItem movieItem);
	
	public void deleteReservation(Customer customer, MovieItem movieItem);
	
	
	
}
