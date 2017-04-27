package teamid9527.moviebooking.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamid9527.moviebooking.dao.CustomerDao;
import teamid9527.moviebooking.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Customer findCustomerById(Integer id) {
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("id", id));
		return (Customer)criteria.uniqueResult();
	}

	public Customer findCustomerByName(String name) {
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("name", name));
		return (Customer)criteria.uniqueResult();
	}

	public void createCustomer(Customer customer) {
		getSession().save(customer);
	}

	public void updateCustomer(Customer customer) {
		//更新前先删除Session中旧的Customer，否则会出现两个id相同的Customer，使得Hibernate不知道持久化哪个
		getSession().evict(getSession().get(Customer.class, customer.getC_id()));
		getSession().update(customer);
	}

	public void deleteCustomerById(Integer id) {
		Customer customer = getSession().get(Customer.class, id);
		if (customer != null)
			getSession().delete(customer);
	}

	

}
