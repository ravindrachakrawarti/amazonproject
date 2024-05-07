package Amazon.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.*;
import Amazon.entity.User;
import Amazon.repository.UserRespority;
import Amazon.service.RazorpayService;
import jakarta.servlet.http.HttpSession;


@RestController

@CrossOrigin("http://localhost:3000")
public class Homecontroller {
	
	
	@Autowired
	private UserRespority userrepositery;
	
    
	
    @Value("${rzp_key_id}")
    private String keyId;

    @Value("${rzp_key_secret}")
    private String secret;
    
    @GetMapping("/payment/{amount}")
    public String Payment(@PathVariable String amount) throws RazorpayException {
        

		 var client=  new RazorpayClient("rzp_test_4xOJiuPbQ8GlQA", "qZNEUVLZPz9p7aTxVAayL5rT");
		
		    JSONObject ob=new JSONObject();
		    ob.put("amount",amount);
		    ob.put("currency", "INR");
		    ob.put("receipt", "txn_235425");
		 
		 //create new order
		    
		    Order order=client.Orders.create(ob);
		    
        String orderId = order.get("id");

        return orderId;
    }
	
	
	
	
 @GetMapping("/")
	private String homepage() {
		
		
		return "index";
		
	}
 @GetMapping("/index")
	private String homepage1() {
		
		
		return "index";
		
	}

	
 @GetMapping("/toys")
	private String Toys() {
		
		
		return "toys";
		
 }
 @GetMapping("/cloths")
	private String cloths() {
		
		
		return "cloths";
		
}
 @GetMapping("/furnichure")
	private String furnichure() {
		
		
		return "furnichure";
		
}
 @GetMapping("/mobile")
	private String mobile() {
		
		
		return "mobile";
		
}
 @GetMapping("/beauty")
	private String beauty() {
		
		
		return "beauty";
		
}
 @GetMapping("/dog")
	private String dog() {
		
		
		return "dog";
		
}
 @GetMapping("/health")
	private String health() {
		
		
		return "health";
		
}
 @GetMapping("/fesion")
	private String fesion() {
		
		
		return "fesion";
		
}
 @GetMapping("/login")
	private String login() {
		
		
		return "login";
		
}
 @GetMapping("/signup")
	private String signup() {
		
		
		return "Registration";
		
}
 @PostMapping("/saveuser")
	private String saveuser(@ModelAttribute User user,HttpSession session) {
		
	           this.userrepositery.save(user);
	
	
	    
	 
	 
		return "login";
		
}
 @PostMapping("/create_order")
	@ResponseBody
	public String createOder(@RequestBody Map<String, Object> data,Principal principal) throws Exception
	{
		
		
		System.out.println(data);
		int amt=Integer.parseInt(data.get("amount").toString());
		 
		 var client=  new RazorpayClient("rzp_test_4xOJiuPbQ8GlQA", "qZNEUVLZPz9p7aTxVAayL5rT");
		
		    JSONObject ob=new JSONObject();
		    ob.put("amount",amt*100);
		    ob.put("currency", "INR");
		    ob.put("receipt", "txn_235425");
		 
		 //create new order
		    
		    Order order=client.Orders.create(ob);
		    
		    System.out.println(order);
		
	return order.toString();
}
}
