package teamid9527.moviebooking.service;

import teamid9527.moviebooking.entities.Customer;

public interface CustomerService {

	public Customer login(String username, String password);
	
	public boolean register(Customer customer);
	
	public boolean update(Customer customer);
}
