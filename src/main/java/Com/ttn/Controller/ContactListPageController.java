package Com.ttn.Controller;

import Com.ttn.Domains.Contact;
import Com.ttn.Domains.User;
import Com.ttn.Services.ServiceInterfaces.CategoryOperationsService;
import Com.ttn.Services.ServiceInterfaces.ContactOperationsService;
import Com.ttn.Services.ServiceInterfaces.UserOperations;
import org.bouncycastle.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@EnableWebMvc
public class ContactListPageController {
    @Autowired
    UserOperations userOperations;
    @Autowired
    ContactOperationsService contactOperationsService;
    @Autowired
    CategoryOperationsService categoryOperationsService;

    @RequestMapping(value = "/contactpage", method = RequestMethod.GET)
    public String main(HttpSession session, Model model) {
        User user=userOperations.getUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
        session.setAttribute("user",user);
        model.addAttribute("username",user.getUserName());
        model.addAttribute("userprofilepic",user.getProfilePic());
        model.addAttribute("categoryNames", categoryOperationsService.getCategoryNamesByUser(user));
        return "ContactList";
    }
    @RequestMapping(value = "/getAllContacts", method = RequestMethod.POST)
    @ResponseBody
    public List<Contact> getAllContacts(HttpSession session) {
        List<Contact> contactList=contactOperationsService.getAllContacts((User) session.getAttribute("user"));

        return contactList;
    }
    @RequestMapping(value = "/showAllCategory",method = RequestMethod.GET)
    public String showAllCategory(HttpSession session,Model model)
    {
        User user=(User)session.getAttribute("user");
        model.addAttribute("categoryList",categoryOperationsService.getCategoryNamesByUser(user));
        return "CategoryList";
    }

}
