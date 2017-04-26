package teamid9527.moviebooking.dao;

import teamid9527.moviebooking.entities.Customer;

public interface CustomerDao {

	public Customer findCustomerById(Integer id);

	public Customer findCustomerByName(String name);
	
}
