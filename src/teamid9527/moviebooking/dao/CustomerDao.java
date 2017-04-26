package teamid9527.moviebooking.dao;

import teamid9527.moviebooking.entities.Customer;

public interface CustomerDao {

	public Customer findCustomerById(Integer id);

	public Customer findCustomerByName(String name);
	
	public void createCustomer(Customer customer);
	
	/**
	 * 根据customer.id更新数据库中对应的记录
	 * @param customer 更新的数据，需要有id
	 */
	public void updateCustomer(Customer customer);
	
	public void deleteCustomerById(Integer id);
	
}
