package teamid9527.moviebooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamid9527.moviebooking.dao.CustomerDao;
import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.exception.LoginException;
import teamid9527.moviebooking.exception.RegisterException;
import teamid9527.moviebooking.exception.UpdateException;
import teamid9527.moviebooking.service.CustomerService;
	
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
		
	public Customer login(String username, String password) {
		Customer customer = customerDao.findCustomerByName(username);
		if (customer == null)
			throw new LoginException("用户不存在");
		if (!password.equals(customer.getPassword()))
			throw new LoginException("用户密码错误");
		return customer;
	}

	public boolean register(Customer customer) {
		Customer _customer = customerDao.findCustomerByName(customer.getName());
		if (_customer != null)
			throw new RegisterException("用户已存在");
		// TODO Auto-generated method stub
		customerDao.createCustomer(customer);
		return true;
	}

	public boolean update(Customer customer) {
		Customer _customer = customerDao.findCustomerByName(customer.getName());
		if (_customer == null)
			throw new UpdateException("用户不存在");
		if (_customer.getC_id() != customer.getC_id())
			throw new UpdateException("没有权限修改该用户");
		customerDao.updateCustomer(customer);
		return true;
	}
	
	

}
