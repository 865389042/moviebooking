package teamid9527.moviebooking.dao;

import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.entities.Reservation;

public interface ReservationDao {

	public Reservation findReservationById(Integer id);
	
	public Reservation findReservationByCustomerId(Integer customer_id);
	
	public Reservation findReservationByCustomer(Customer customer);
	
}
