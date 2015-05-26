package ke.co.turbosoft.med.web;

import ke.co.turbosoft.med.entity.BenefitRef;
import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.service.BenefitRefService;
import ke.co.turbosoft.med.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

import static ke.co.turbosoft.med.web.SecurityHelper.getSessionUser;

/**
 * Created by akipkoech on 26/05/15.
 */
@Controller
@RequestMapping("/ref")
public class AdminRefHandler extends AbstractHandler {

    @Autowired
    private BenefitRefService benefitRefService;

    @RequestMapping(value = "/befenefit/store", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public String storeBenefit(
            @RequestParam(value = "data", required = true) String jsonData,
            HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        JsonObject jsonObj = parseJsonObject(jsonData);

        Result<BenefitRef> ar = benefitRefService.store(
                getIntegerValue(jsonObj.get("benefitCode")),
                jsonObj.getString("benefitName"),
                jsonObj.getString("description"),
                sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }

}
