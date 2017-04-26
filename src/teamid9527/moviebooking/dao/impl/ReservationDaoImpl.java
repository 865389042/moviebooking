package teamid9527.moviebooking.dao.impl;

import java.util.List;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamid9527.moviebooking.dao.ReservationDao;
import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.entities.MovieItem;
import teamid9527.moviebooking.entities.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SessionFactory sessionFactory;

	//获取和当前线程绑定的session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Reservation findReservationById(Integer id) {
		Reservation reservation = getSession().get(Reservation.class, id);
		return reservation;
	}

	public Reservation findReservationByCustomerId(Integer customer_id) {
		Criteria criteria = getSession().createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("customer.id", customer_id));
		return (Reservation)criteria.uniqueResult();
	}

	public Reservation findReservationByCustomer(Customer customer) {
		return findReservationByCustomerId(customer.getC_id());
	}


}
