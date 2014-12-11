package ke.co.turbosoft.med.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/care")
public class CareController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCarePage(){
		return "care";
	}

}
