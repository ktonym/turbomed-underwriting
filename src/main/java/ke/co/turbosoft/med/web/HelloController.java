package ke.co.turbosoft.med.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HelloController {

	@RequestMapping(method=RequestMethod.GET,value="/")
	public String printwelcome(ModelMap model){
		model.addAttribute("message", "Hello world!!");
		return "index";
	}
}
