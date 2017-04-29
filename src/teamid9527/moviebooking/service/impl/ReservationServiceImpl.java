package teamid9527.moviebooking.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamid9527.moviebooking.dao.ReservationDao;
import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.entities.MovieItem;
import teamid9527.moviebooking.entities.Reservation;
import teamid9527.moviebooking.exception.DeleteException;
import teamid9527.moviebooking.exception.InsertException;
import teamid9527.moviebooking.exception.QueryException;
import teamid9527.moviebooking.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	
	public Reservation queryReservation(Customer customer) {
		if (customer == null || customer.getC_id() == null)
			throw new QueryException("非注册用户不可查询订单");
		Reservation reservation = reservationDao.findReservationByCustomer(customer);
		if (reservation == null) {
			System.out.println("用户订单不存在，创建新的用户订单");
			reservation = new Reservation();
			reservation.setCustomer(customer);
			reservationDao.createReservation(reservation);
		}
		return reservation;
	}

	public void updateReservation(Customer customer, Set movieItems) {
		if (customer == null || customer.getC_id() == null)
			throw new QueryException("非注册用户不可修改订单");
		Reservation reservation = reservationDao.findReservationByCustomer(customer);
		if (reservation == null) {
			System.out.println("用户订单不存在，创建新的用户订单");
			reservation = new Reservation();
			reservation.setCustomer(customer);
			reservationDao.createReservation(reservation);
		}
		reservation.setMovieItems(movieItems);
		reservationDao.updateReservation(reservation);
	}

	public void insertReservation(Customer customer, MovieItem movieItem) {
		if (customer == null || customer.getC_id() == null)
			throw new QueryException("非注册用户不可添加电影条目");
		Reservation reservation = reservationDao.findReservationByCustomer(customer);
		if (reservation == null) {
			System.out.println("用户订单不存在，创建新的用户订单");
			reservation = new Reservation();
			reservation.setCustomer(customer);
			reservationDao.createReservation(reservation);
		}
		Set movieItems = reservation.getMovieItems();
		boolean success = movieItems.add(movieItem);
		if (!success)
			throw new InsertException("订单已存在不可重复添加");
		
	}

	public Reservation deleteReservation(Customer customer, MovieItem movieItem) {
		if (customer == null || customer.getC_id() == null)
			throw new QueryException("非注册用户不可删除电影条目");
		Reservation reservation = reservationDao.findReservationByCustomer(customer);
		if (reservation == null) {
			System.out.println("用户订单不存在，创建新的用户订单");
			reservation = new Reservation();
			reservation.setCustomer(customer);
			reservationDao.createReservation(reservation);
			throw new DeleteException("删除失败：订单中不存在该电影条目");
		}
		Set movieItems = reservation.getMovieItems();
		boolean success = movieItems.remove(movieItem);
		if (!success)
			throw new InsertException("删除失败：订单中不存在该电影条目");
		return reservation;
	}

}
