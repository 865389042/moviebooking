package teamid9527.moviebooking.dao;

import teamid9527.moviebooking.entities.Customer;

public interface CustomerDao {

	public Customer findCustomerById(Integer id);

	public Customer findCustomerByName(String name);
	
	public void createCustomer(Customer customer);
	
	/**
	 * ����customer.id�������ݿ��ж�Ӧ�ļ�¼
	 * @param customer ���µ����ݣ���Ҫ��id
	 */
	public void updateCustomer(Customer customer);
	
	public void deleteCustomerById(Integer id);
	
}
