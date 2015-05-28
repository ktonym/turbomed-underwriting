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
import java.util.List;

import static ke.co.turbosoft.med.web.SecurityHelper.getSessionUser;

/**
 * Created by akipkoech on 26/05/15.
 */
@Controller
@RequestMapping("/ref")
public class AdminRefHandler extends AbstractHandler {

    @Autowired
    private BenefitRefService benefitRefService;

    @RequestMapping(value = "/benefit/store", method = RequestMethod.POST, produces = {"application/json"})
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

    @RequestMapping (value = "/benefit/remove", method=RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public String removeBenefit(
            @RequestParam(value="benefitCode", required = true) Integer benefitCode,
            HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<BenefitRef> ar = benefitRefService.remove(benefitCode,sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }

    @RequestMapping(value = "/benefit/search", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public String findBenefit(
            @RequestParam(value = "benefitName",required = true) String benefitName,
            HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<List<BenefitRef>> ar = benefitRefService.search(benefitName,sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }

    @RequestMapping(value = "/benefit/findAll", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public String findAllBenefits(HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<List<BenefitRef>> ar = benefitRefService.findAll(sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }

    @RequestMapping(value = "/benefit/find", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public String findBenefit(
            @RequestParam(value = "benefitCode") Integer benefitCode,
            HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<BenefitRef> ar = benefitRefService.find(
                benefitCode,sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }
}
