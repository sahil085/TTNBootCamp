package Com.ttn.Controller;

import Com.ttn.Domains.User;
import Com.ttn.Services.ServiceInterfaces.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;


@Controller
public class LoginRegistrationController {

    @Autowired
    UserRegistrationService userRegistrationService;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody String userRegistration(@ModelAttribute User user, BindingResult bindingResult,
                                                 @RequestParam("file") MultipartFile file) {

        if (bindingResult.hasErrors()) {
            return "Error has occured";
        } else {
            Random random = new Random();
            int randomnumber = random.nextInt(100000);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    File serverFile = new File("/home/sahil/Desktop/ttn/src/main/webapp/resources/profilepic/" + randomnumber + file.getOriginalFilename());
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();
                    user.setProfilePic( randomnumber + file.getOriginalFilename());

                } catch (Exception e) {
                    System.out.println(e);
                }

            }
            return userRegistrationService.userRegistration(user);


        }
    }
        @RequestMapping(value = "/accessdeniedpage", method = RequestMethod.GET)
        public String mainpage ()
        {
            return "accessdenied";
        }


}
