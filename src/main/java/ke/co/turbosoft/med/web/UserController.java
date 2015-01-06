package ke.co.turbosoft.med.web;

import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.service.UserService;
import ke.co.turbosoft.med.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

    @ModelAttribute("user")
    public User construct(){
        return new User();
    }
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
       // model.addAttribute("userList",)
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOne(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegistration(){
		return "user-register";
	}

    @RequestMapping(method = RequestMethod.POST,value="/register")
    public String doRegistration(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:register?success=true";
    }

}
