package ke.co.turbosoft.med.web;

import ke.co.turbosoft.med.entity.*;
import ke.co.turbosoft.med.service.CategoryService;
import ke.co.turbosoft.med.service.CorpAnnivService;
import ke.co.turbosoft.med.service.CorporateService;
import ke.co.turbosoft.med.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static ke.co.turbosoft.med.web.SecurityHelper.getSessionUser;

/**
 * Created by akipkoech on 12/10/14.
 */
@Controller
@RequestMapping("/corporate")
public class CorporateHandler extends AbstractHandler{

    @Autowired
    private CorporateService corporateService;

    @Autowired
    private CorpAnnivService corpAnnivService;

    @Autowired
    private CategoryService categoryService;

    static final DateTimeFormatter DATE_FORMAT_yyyyMMdd =  DateTimeFormatter.ofPattern("yyyyMMdd");
//    @ModelAttribute("corporate")
//    public Corporate create(){
//        return new Corporate();
//    }

    @InitBinder
    public void initBinder(WebDataBinder binder){

        binder.registerCustomEditor(LocalDate.class,new LocalDateEditor(DATE_FORMAT_yyyyMMdd,true));

    }

    @RequestMapping(value="/findAll",method = RequestMethod.GET, produces={"application/json"})
    @ResponseBody
    public String findAll(HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<List<Corporate>> ar = corporateService.findAll(sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }


    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public String find (
            @RequestParam(value = "idCorporate", required = true) Integer idCorporate,
            HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        Result<Corporate> ar = corporateService.find(idCorporate,sessionUser.getUsername());

        if(ar.isSuccess()){

            return getJsonSuccessData(ar.getData());

        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }

    @RequestMapping(value="/store", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public String store (
            @RequestParam(value = "data", required = true) String jsonData,
            HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        JsonObject jsonObj = parseJsonObject(jsonData);

//        String dateVal = null;
//
//           if(!jsonObj.getString("joined").isEmpty() && jsonObj.getString("joined").length()>0){
//                dateVal = jsonObj.getString("joined");
//           }
        String dateVal = jsonObj.getString("joined");

        Result<Corporate> ar = corporateService.store(
                getIntegerValue(jsonObj.get("idCorporate")),
                jsonObj.getString("corporateName"),
                jsonObj.getString("abbreviation"),
                jsonObj.getString("tel"),
                jsonObj.getString("email"),
                jsonObj.getString("postalAddress"),
                LocalDate.parse(dateVal, DATE_FORMAT_yyyyMMdd),
                sessionUser.getUsername());

        if(ar.isSuccess()){
            return getJsonSuccessData(ar.getData());
        } else {
            return getJsonErrorMsg(ar.getMsg());
        }

    }

    @RequestMapping(value = "/treenode", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public String getCorpTreeNode(
            @RequestParam(value = "node", required = true) String node,
            HttpServletRequest request){

        User sessionUser = getSessionUser(request);

        logger.info(node);

        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("success", true);
        JsonArrayBuilder childrenArrayBuilder = Json.createArrayBuilder();

        if(node.equals("root")){

            Result<List<Corporate>> ar = corporateService.findAll(sessionUser.getUsername());

            if(ar.isSuccess()){

                for(Corporate corporate: ar.getData()){

                    List<CorpAnniv> annivs = corpAnnivService.findByCorporate(corporate,sessionUser.getUsername()).getData();

                    childrenArrayBuilder.add(
                            Json.createObjectBuilder().add("id", getTreeNodeId(corporate))
                                                      .add("text", corporate.getCorporateName())
                                                      .add("leaf", annivs.isEmpty())
                    );

                }

            } else {

                return getJsonErrorMsg(ar.getMsg());

            }

        } else if ( node.startsWith("S")){

            String[] idSplit = node.split("_");
            int idCorporate = Integer.parseInt(idSplit[1]);
            Result<Corporate> ar = corporateService.find(idCorporate, sessionUser.getUsername());
            List<CorpAnniv> annivs = corpAnnivService.findByCorporate(ar.getData(),sessionUser.getUsername()).getData();

            for(CorpAnniv anniv: annivs){
                //TODO complete creation of this builder
                List<Category> cats = categoryService.findByAnniv(anniv, sessionUser.getUsername()).getData();

                childrenArrayBuilder.add(
                        Json.createObjectBuilder()
                                .add("id", getTreeNodeId(anniv))
                                .add("text", anniv.getAnniv())
                                .add("leaf", cats.isEmpty())
                );


            }


        } else if ( node.startsWith("A")){

            String[] idSplit = node.split("_");
            int idCorpAnniv = Integer.parseInt(idSplit[1]);
            Result<CorpAnniv> ar = corpAnnivService.find(idCorpAnniv, sessionUser.getUsername());
            List<Category> cats = categoryService.findByAnniv(ar.getData(),sessionUser.getUsername()).getData();

            for(Category cat: cats){

                childrenArrayBuilder.add(
                        Json.createObjectBuilder()
                                .add("id", getTreeNodeId(cat))
                                .add("text", cat.getCat())
                                .add("leaf", true)
                );

            }

        }

        builder.add("children", childrenArrayBuilder);
        return toJsonString(builder.build());

    }

    private String getTreeNodeId(EntityItem obj) {

        String id = null;

        if(obj instanceof Corporate){
            id = "S_" + obj.getId();
        } else if (obj instanceof CorpAnniv){
            id = "A_" + obj.getId();
        } else if (obj instanceof Category){
            id = "C_" + obj.getId();
        }

        return id;
    }


//    @RequestMapping(value = "/{pageNumber}",method = RequestMethod.GET)
//    public String getCorporatePage(@PathVariable Integer pageNumber, Model model){
//
//        Page<Corporate> page=corporateService.getCorporates(pageNumber);
//        int current = page.getNumber()+1;
//        int begin = Math.max(1, current - 2);
//        int end = Math.min(begin + 2, page.getTotalPages());
//
//
//        model.addAttribute("corpPage",page);
//        model.addAttribute("corpList", page.getContent());
//        model.addAttribute("beginIndex",begin);
//        model.addAttribute("endIndex",end);
//        model.addAttribute("currentIndex",current);
//        return "corporates";
//
//    }

//    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
//    public String editCorporate(@PathVariable Integer id, Model model){
//        Corporate corporate=corporateService.search(id);
//        model.addAttribute("corporate", corporate);
//        return "corporate";
//    }
//
//    @RequestMapping(value="/add")
//    public String showRegistration(){
//        return "corp-register";
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String doRegistration(@ModelAttribute("corporate") Corporate corporate, BindingResult result /*, RedirectAttributes redirectAttributes*/){
//
//        if(result.hasErrors()){
//            return "add";
//        }
//
//        corporateService.save(corporate);
//        //redirectAttributes.addFlashAttribute("success",true);
//        return "redirect:add?success=true";
//    }


}
