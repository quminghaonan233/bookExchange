package software.nju.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SortingController {
	
	@GetMapping("/searchAll")
	public String sortingByCredit() {
		
		return "searchAll";
	}
	
	
	@GetMapping("/searchAll")
	public String sortingByTimestamp() {
		
		return "searchAll";
	}

}
