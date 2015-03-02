package ke.co.turbosoft.med.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ktonym on 1/13/15.
 */
@Controller
public class SecurityHandler {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
