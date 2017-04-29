package teamid9527.moviebooking.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import javassist.expr.NewArray;

import org.hibernate.annotations.Parameter;
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.entities.Movie;
import teamid9527.moviebooking.entities.MovieItem;
import teamid9527.moviebooking.entities.Reservation;
import teamid9527.moviebooking.service.CustomerService;
import teamid9527.moviebooking.service.MovieItemService;
import teamid9527.moviebooking.service.ReservationService;

@SessionAttributes(value={"customer2", "reservation", "movieItems", "movies", "cinemas"})
@Controller
public class CustomerHandler {
	
	private static final String SUCCESS = "success"; 
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private MovieItemService movieItemService;
	
	@RequestMapping("/login")
	public String customerLogin(Customer customer, Map<String, Object> map) {
		System.out.println("Login: Customer: " + customer);
		try {
			Customer customer2 = customerService.login(customer.getName(), customer.getPassword());
			map.put("customer2", customer2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			map.put("exception", e.getMessage());
			return "login";
		}
		
		return SUCCESS;
	}
	
	@RequestMapping("gotoRegister")
	public String customerGotoRegister() {
		return "register";
	}
	
	@RequestMapping("register")
	public String customerRegister(Customer customer, Map<String, Object> map) {
		try {
			Customer customer2 = customerService.register(customer);
			map.put("customer2", customer2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			map.put("exception", e.getMessage());
			return "register";
		}
		return SUCCESS;
	}
	
	@RequestMapping("gotoLogin")
	public String customerGotoLogin(HttpServletRequest request) {
		request.getSession().removeAttribute("customer2");
		return "login";
	}
	
	@RequestMapping("update")
	public String customerUpdate(Customer customer, Map<String, Object> map) {
		if (customer == null || customer.getC_id() == null || customer.getC_id().equals("")) {
			map.put("exception", "用户会话已结束");
			return "login";
		}
			
		try {
			customerService.update(customer);
			map.put("customer2", customer);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			map.put("exception", e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@RequestMapping("/queryReservation")
	public String queryReservation(@RequestParam(value="c_id") Integer c_id,
			@RequestParam(value="name")String name, Map<String, Object> map) {
		Customer customer = (Customer) map.get("customer2");
		Reservation reservation = reservationService.queryReservation(customer);
		if (reservation == null || !reservation.getCustomer().getName().equals(name)) {
			map.put("exception", "无权限查看该用户的订单");
			return "login";
		}
		System.out.println("Reservation： " + reservation);
		map.put("reservation", reservation);
		return "reservation";
	}
	
	@RequestMapping("/backToInfo")
	public String backToInfo(Map<String, Object> map) {
		System.out.println("backToInfo");
		Customer customer = (Customer) map.get("customer2");
		if (customer == null || customer.getC_id() == null) {
			map.put("exception", "用户会话已结束");
			return "login";
		}
		return SUCCESS;
	}
	
	@RequestMapping("/cancelMovieItem")
	public String cancelMovieItem(@RequestParam(value="id")  Integer id, Map<String, Object> map) {
		Customer customer = (Customer) map.get("customer2");
		MovieItem movieItem = new MovieItem();
		movieItem.setId(id);
		try {
			Reservation reservation = reservationService.deleteReservation(customer, movieItem);
			map.put("reservation", reservation);
		} catch (Exception e) {
			map.put("exception", e.getMessage());
		}
		return "reservation";
	}
	
	@RequestMapping("/queryCinema")
	public String queryCinema(Map<String, Object> map) {
		Map movieItemsMap = movieItemService.queryAllMovieItemByCinema();
		map.put("cinemas", movieItemsMap);
		return "queryCinema";
	}
	
	@RequestMapping("/queryMovie")
	public String queryMovie(Map<String, Object> map) {
		Map movieItemsMap = movieItemService.queryAllMovieItemByMovie();
		map.put("movies", movieItemsMap);
		return "queryMovie";
	}
	
	@RequestMapping("/queryMovieItemsByCinema")
	public String queryMovieItemsByCinema(@RequestParam(value="id") Integer id, Map<String, Object> map) {
		List movieItems =  movieItemService.queryMovieItemByCinema(id);
		map.put("movieItems", movieItems);
		return "movieItems";
		
	}
	
	@RequestMapping("/queryMovieItemsByMovie")
	public String queryMovieItemsByMovie(@RequestParam(value="id") Integer id, Map<String, Object> map) {
		List movieItems = movieItemService.queryMovieItemByMovie(id);
		map.put("movieItems", movieItems);
		return "movieItems";
	}
	
	@RequestMapping("/addMovieItem")
	public String addMovieItem(@RequestParam(value="id") Integer id, Map<String, Object> map) {
		Customer customer = (Customer) map.get("customer2");
		MovieItem movieItem = new MovieItem();
		reservationService.insertReservationByMovieItemId(customer, id);
		return "movieItems";
	}
}
