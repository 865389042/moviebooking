package teamid9527.moviebooking.test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import teamid9527.moviebooking.dao.CinemaDao;
import teamid9527.moviebooking.dao.CityDao;
import teamid9527.moviebooking.dao.CustomerDao;
import teamid9527.moviebooking.dao.MovieDao;
import teamid9527.moviebooking.dao.MovieItemDao;
import teamid9527.moviebooking.dao.ProvinceDao;
import teamid9527.moviebooking.dao.ReservationDao;
import teamid9527.moviebooking.dao.TownDao;
import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.City;
import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.entities.Movie;
import teamid9527.moviebooking.entities.MovieItem;
import teamid9527.moviebooking.entities.Province;
import teamid9527.moviebooking.entities.Reservation;
import teamid9527.moviebooking.entities.Town;

public class movieBookingTest {

	private ApplicationContext ctx = null;
	private ProvinceDao provinceDao;
	private CityDao cityDao;
	private TownDao townDao;
	private CinemaDao cinemaDao;
	private MovieDao movieDao;
	private CustomerDao customerDao;
	private MovieItemDao movieItemDao;
	private ReservationDao reservationDao;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		provinceDao = ctx.getBean(ProvinceDao.class);
		cityDao = ctx.getBean(CityDao.class);
		townDao = ctx.getBean(TownDao.class);
		cinemaDao = ctx.getBean(CinemaDao.class);
		movieDao = ctx.getBean(MovieDao.class);
		customerDao = ctx.getBean(CustomerDao.class);
		movieItemDao = ctx.getBean(MovieItemDao.class);
		reservationDao = ctx.getBean(ReservationDao.class);
	}

	//@Test
	public void testdeleteMovieItemById() {
		movieItemDao.deleteMovieItemById(6);
	}
	
	//@Test
	public void testupdateMovieItem() {
		MovieItem movieItem = movieItemDao.findMovieItemById(6);
		movieItem.setPrice(30);
		movieItemDao.updateMovieItem(movieItem);
	}
	
	//@Test
	public void testcreateMovieItem() {
		MovieItem movieItem = new MovieItem();
		
		Movie movie = movieDao.findMovieById(1);
		Cinema cinema = cinemaDao.findCinemaById(1);
		
		movieItem.setMovie(movie);
		movieItem.setCinema(cinema);
		movieItem.setPrice(60);
		movieItem.setSeat(50);
		movieItem.setDuration("15:00-17:00");
		
		movieItemDao.createMovieItem(movieItem);
	}
	
	//@Test
	public void testdeleteReservationById() {
		reservationDao.deleteReservationById(3);
	}
	
	//@Test
	public void testupdateReservation() {
		Reservation reservation = reservationDao.findReservationById(2);
		
		MovieItem movieItem = movieItemDao.findMovieItemById(5);
		System.out.println(reservation.getMovieItems().size());

		
		//测试了向set中重复添加
		reservation.getMovieItems().add(movieItem);
		System.out.println(reservation.getMovieItems().size());
		reservationDao.updateReservation(reservation);
	}
	
	//@Test
	public void testcreateReservation() {
		Reservation reservation = new Reservation();
		
		Customer customer = customerDao.findCustomerById(3);
		Set<MovieItem> movieItems = new HashSet<MovieItem>();
		MovieItem movieItem1 = movieItemDao.findMovieItemById(1);
		MovieItem movieItem2 = movieItemDao.findMovieItemById(2);
		movieItems.add(movieItem1);
		movieItems.add(movieItem2);
		
		reservation.setCustomer(customer);
		reservation.setMovieItems(movieItems);
		
		reservationDao.createReservation(reservation);
	}
	
	//@Test
	public void testdeleteCustomerById() {
		customerDao.deleteCustomerById(6);	
	}
	
	//@Test
	public void testupdateCustomer() {
		Customer customer = new Customer();
		
		customer.setC_id(3);
		customer.setName("Cindy");
		customer.setPassword("cindy12345");
		customer.setEamil("Cindy@qq.com");
		
		System.out.println(customer);
		
		customerDao.updateCustomer(customer);
		
		System.out.println(customer);
	}
	
	//@Test
	public void testcreateCustomer() {
		Customer customer = new Customer();
		
		customer.setName("Cindy");
		customer.setPassword("cindy1234");
		customer.setEamil("Cindy@qq.com");
		
		System.out.println(customer);
		
		customerDao.createCustomer(customer);
		
		System.out.println(customer);
	}
	
	//@Test
	public void testfindReservationByCustomer() {
		Customer customer = customerDao.findCustomerById(1);
		Reservation reservation = reservationDao.findReservationByCustomer(customer);
		System.out.println(reservation);
	}
	
	//@Test
	public void testfindReservationByCustomId() {
		Reservation reservation = reservationDao.findReservationByCustomerId(2);
		System.out.println(reservation);
	}
	
	//@Test
	public void testfindReservationById() {
		Reservation reservation = reservationDao.findReservationById(2);
		System.out.println(reservation);
	}
	
	//@Test
	public void testfindMovieItemsByCinema() {
		Cinema cinema = cinemaDao.findCinemaById(2);
		List list = movieItemDao.findMovieItemsByCinema(cinema);
		System.out.println(list);
	}
	
	//@Test
	public void testfindMovieItemsByCinemaId() {
		List list = movieItemDao.findMovieItemsByCinemaId(1);
		System.out.println(list);
	}
	
	//@Test
	public void testfindMovieItemsByMovie() {
		Movie movie = movieDao.findMovieById(2);
		List list = movieItemDao.findMovieItemsByMovie(movie);
		System.out.println(list);
	}
	
	//@Test
	public void testfindMovieItemsByMovieId() {
		List list = movieItemDao.findMovieItemsByMovieId(1);
		System.out.println(list);
	}
 	
	//@Test
	public void testfindMovieItemById() {
		MovieItem movieItem = movieItemDao.findMovieItemById(5);
		System.out.println(movieItem);
		System.out.println(movieItem.getReservations());
	}
	
	
	//@Test
	public void testfindCustomerByName() {
		Customer customer = customerDao.findCustomerByName("Bob");
		System.out.println(customer);
	}
	
	//@Test
	public void testfindCustomerById() {
		Customer customer = customerDao.findCustomerById(1);
		System.out.println(customer);
	}
	
	//@Test
	public void testfindMovieByName() {
		List list = movieDao.findMovieByName("金刚狼3");
		System.out.println(list);
	}
	
	//@Test
	public void testfindMovieById() {
		Movie movie = movieDao.findMovieById(1);
		System.out.println(movie);
	}
	
	//@Test
	public void testfindCinemasByTown() {
		Town town = townDao.findTownById(1);
		List cinemas = cinemaDao.findCinemasByTown(town);
		System.out.println(cinemas);
	}
	
	//@Test
	public void testfindCinemasByTownId() {
		List cinemas = cinemaDao.findCinemasByTownId(1);
		System.out.println(cinemas);
	}
	
	//@Test
	public void testfindCinemaByName() {
		Cinema cinema = cinemaDao.findCinemaByName("金逸珠江影城");
		System.out.println(cinema);
	}
	
	//@Test
	public void testfindCinemaById() {
		Cinema cinema = cinemaDao.findCinemaById(2);
		System.out.println(cinema);
	}
	
	//@Test
	public void testfindTownsByCity() {
		City city = cityDao.findCityById(1);
		System.out.println(townDao.findTownsByCity(city));
	}
		
	//@Test
	public void testfindTownsByCityId() {
		System.out.println(townDao.findTownsByCityId(1));
	}
		
	//@Test
	public void testfindTownById() {
		Town town = townDao.findTownById(1);
		System.out.println(town);
	}
		
	//@Test
	public void testfindTownByName(){
		Town town = townDao.findTownByName("番禺区");
		System.out.println(town);
	}
	
	//@Test
	public void testfindCitysByProvince() {
		Province province = provinceDao.findProvinceById(1);
		System.out.println(cityDao.findCitysByProvince(province));
	}
	
	//@Test
	public void testfindCitysByProvinceId() {
		System.out.println(cityDao.findCitysByProvinceId(1));
	}
	
	//@Test
	public void testfindCityById() {
		City city = cityDao.findCityById(2);
		System.err.println(city);
	}
	
	//@Test
	public void testfindCityByName(){
		City city = cityDao.findCityByName("广州市");
		System.out.println(city);
	}
	
	//@Test
	public void testqueryProvince() {
		Province province = provinceDao.findProvinceById(1);
		System.out.println(province);
	}
	
	//@Test
	public void testfindProvinceIdByName() {
		Integer id = provinceDao.findProvinceIdByName("广东省");
		System.out.println(id);
	}
	//@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	
	
	
}
