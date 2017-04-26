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
	
	//获取和当前线程绑定的session
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

}
