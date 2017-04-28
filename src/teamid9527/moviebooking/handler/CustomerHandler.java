package teamid9527.moviebooking.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import teamid9527.moviebooking.entities.Customer;
import teamid9527.moviebooking.service.CustomerService;

@SessionAttributes(value={"customer2"})
@Controller
public class CustomerHandler {
	
	private static final String SUCCESS = "success"; 
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/login")
	public String customerLogin(Customer customer, Map<String, Object> map) {
		try {
			Customer customer2 = customerService.login(customer.getName(), customer.getPassword());
			map.put("customer2", customer2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			map.put("exception", e.getMessage());
			return "index";
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
	public String customerGotoLogin() {
		return "index";
	}
	
	@RequestMapping("update")
	public String customerUpdate(Customer customer, Map<String, Object> map) {
		try {
			customerService.update(customer);
			map.put("customer2", customer);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			map.put("exception", e.getMessage());
		}
		
		return SUCCESS;
	}
}
