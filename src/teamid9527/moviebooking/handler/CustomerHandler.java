package teamid9527.moviebooking.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/moviebooking")
@Controller
public class CustomerHandler {
	
	private static final String SUCCESS = "success"; 
	
	@RequestMapping("/login")
	public String customerLogin() {
		System.out.println("customerLogin");
		return SUCCESS;
		
	}
}
