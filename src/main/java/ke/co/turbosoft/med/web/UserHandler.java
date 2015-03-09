package ke.co.turbosoft.med.web;

import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.service.UserService;
import ke.co.turbosoft.med.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ke.co.turbosoft.med.web.SecurityHelper.getSessionUser;

@Controller
@RequestMapping("/user")
public class UserHandler extends AbstractHandler{
	
	@Autowired
	private UserService userService;


    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public String find(@RequestParam(value = "username") String username,
                       HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<User> ar = userService.find(username, sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
	public String findAll(HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<List<User>> ar = userService.findAll(sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

	}

    @RequestMapping(value = "/store", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public String store(@RequestParam(value = "data", required = true) String jsonData,
                        HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        JsonObject jsonObj = parseJsonObject(jsonData);

        Result<User> ar = userService.store(
                jsonObj.getString("username"),
                jsonObj.getString("email"),
                jsonObj.getString("password"),
                jsonObj.getString("firstName"),
                jsonObj.getString("lastName"),
                sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public String remove(@RequestParam(value="username") String username,
                         HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<User> ar = userService.remove(username, sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }
    }

}
