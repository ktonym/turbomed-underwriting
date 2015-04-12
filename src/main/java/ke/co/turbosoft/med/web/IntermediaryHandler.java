package ke.co.turbosoft.med.web;

import ke.co.turbosoft.med.entity.Intermediary;
import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.service.IntermediaryService;
import ke.co.turbosoft.med.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ke.co.turbosoft.med.web.SecurityHelper.getSessionUser;

/**
 * Created by ktonym on 4/12/15.
 */
@Controller
@RequestMapping("/intermediary")
public class IntermediaryHandler extends AbstractHandler{

    @Autowired
    private IntermediaryService intermediaryService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public String findAll(HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<List<Intermediary>> ar = intermediaryService.findAll(sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }




}
