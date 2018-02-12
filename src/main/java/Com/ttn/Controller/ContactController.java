package Com.ttn.Controller;

import Com.ttn.Domains.Contact;
import Com.ttn.Domains.User;
import Com.ttn.Services.ServiceInterfaces.ContactOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ContactController {
    @Autowired
    ContactOperationsService contactOperationsService;

    @RequestMapping(value = "/addContact",method = RequestMethod.POST)
    public @ResponseBody String addContact(@ModelAttribute Contact contact,
                                           BindingResult bindingResult,
                                           @RequestParam("categoryNames") String[] categoryName,
                                           HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            System.out.println(bindingResult.getAllErrors());
            return "Error Please try Again";
        }
        else {
            contact.setCreatedBy((User)session.getAttribute("user"));
           return contactOperationsService.addContact(contact,categoryName);
        }
    }

    @RequestMapping(value = "/updateContact",method = RequestMethod.POST)
    public @ResponseBody String updateContact(@ModelAttribute Contact contact,
                                           BindingResult bindingResult,
                                           @RequestParam("categoryNames") String[] categoryName,
                                           HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            System.out.println(bindingResult.getAllErrors());
            return "Error Please try Again";
        }
        else {
            contact.setCreatedBy((User)session.getAttribute("user"));
            return contactOperationsService.updateContactDetails(contact,categoryName);
        }
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public @ResponseBody String deleteContact(@RequestParam("id") long id)
    {
        return contactOperationsService.deleteContact(id);

    }

}
