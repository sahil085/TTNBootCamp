package Com.ttn.Controller;

import Com.ttn.Services.ServiceInterfaces.UserOperations;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class HomePageController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homePage(SecurityContextHolder auth)
    {

        Collection<?extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        String role=null;
        //set page default to rules common

        for(int i=0;i<granted.size();i++){
            role = granted.toArray()[i] + "";
            System.out.println("role verified" + i + " is -> " + role);
        }
        if(role.equals("USER"))
        {
            return "redirect:/contactpage";
        }
        else
        {
            return "index";
        }

    }

@Autowired
UserOperations userOperations;
@RequestMapping(value = "/user",method = RequestMethod.GET)
    public void getname()
{
//    userOperations.getUserByName( );

}

}
