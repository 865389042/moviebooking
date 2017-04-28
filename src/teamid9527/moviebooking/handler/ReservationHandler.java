package teamid9527.moviebooking.handler;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.entities.Reservation;
import teamid9527.moviebooking.service.ReservationService;

@SessionAttributes(value={"reservation"})
//@Controller
public class ReservationHandler {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/queryReservation")
	public String queryReservation(@RequestParam(value="c_id") Integer c_id,
			@RequestParam(value="name")String name, Map<String, Object> map) {
		Customer customer = new Customer();
		customer.setC_id(c_id);
		Reservation reservation = reservationService.queryReservation(customer);
		if (!reservation.getCustomer().getName().equals(name)) {
			map.put("exception", "无权限查看该用户的订单");
			return "login";
		}
		map.put("reservation", reservation);
		return "reservation";
		
	}
	
}
