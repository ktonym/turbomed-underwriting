package ke.co.turbosoft.med.web;

import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.service.CorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by akipkoech on 12/10/14.
 */
@Controller
public class CorpController {

    @Autowired
    private CorporateService corporateService;

    @RequestMapping("/corporate")
    public String getCorporates(Model model){
        model.addAttribute("corps",corporateService.findAll());
        return "corps";
    }

    @RequestMapping(value = "/corporates/{pageNumber}",method = RequestMethod.GET)
    public String getCorporatePage(@PathVariable Integer pageNumber, Model model){

        Page<Corporate> page=corporateService.getCorporates(pageNumber);
        int current = page.getNumber()+1;
        int begin = Math.max(1, current - 1);
        int end = Math.min(begin + 2, page.getTotalPages());

        model.addAttribute("corpPage",page);
        model.addAttribute("corpList", page.getContent());
        model.addAttribute("beginIndex",begin);
        model.addAttribute("endIndex",end);
        model.addAttribute("currentIndex",current);
        return "corporates";

    }

    @RequestMapping(value = "/corporates/edit/{id}",method = RequestMethod.GET)
    public String editCorporate(@PathVariable Integer id, Model model){
        Corporate corporate=corporateService.search(id);
        model.addAttribute("corporate", corporate);
        return "corporate";
    }


}
