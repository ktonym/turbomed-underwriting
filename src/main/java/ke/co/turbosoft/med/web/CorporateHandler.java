package ke.co.turbosoft.med.web;

import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.service.CorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by akipkoech on 12/10/14.
 */
@Controller
@RequestMapping("/corporates")
public class CorporateHandler {

    @Autowired
    private CorporateService corporateService;

    @ModelAttribute("corporate")
    public Corporate create(){
        return new Corporate();
    }

    @RequestMapping("/corporate")
    public String getCorporates(Model model){
        model.addAttribute("corps",corporateService.findAll());
        return "corps";
    }

    @RequestMapping(value = "/{pageNumber}",method = RequestMethod.GET)
    public String getCorporatePage(@PathVariable Integer pageNumber, Model model){

        Page<Corporate> page=corporateService.getCorporates(pageNumber);
        int current = page.getNumber()+1;
        int begin = Math.max(1, current - 2);
        int end = Math.min(begin + 2, page.getTotalPages());

        
        model.addAttribute("corpPage",page);
        model.addAttribute("corpList", page.getContent());
        model.addAttribute("beginIndex",begin);
        model.addAttribute("endIndex",end);
        model.addAttribute("currentIndex",current);
        return "corporates";

    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editCorporate(@PathVariable Integer id, Model model){
        Corporate corporate=corporateService.search(id);
        model.addAttribute("corporate", corporate);
        return "corporate";
    }

    @RequestMapping(value="/add")
    public String showRegistration(){
        return "corp-register";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doRegistration(@ModelAttribute("corporate") Corporate corporate, BindingResult result /*, RedirectAttributes redirectAttributes*/){

        if(result.hasErrors()){
            return "add";
        }

        corporateService.save(corporate);
        //redirectAttributes.addFlashAttribute("success",true);
        return "redirect:add?success=true";
    }


}
