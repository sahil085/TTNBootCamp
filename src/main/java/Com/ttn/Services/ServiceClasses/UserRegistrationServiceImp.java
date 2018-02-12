package Com.ttn.Services.ServiceClasses;

import Com.ttn.Dao.DaoInterfaces.UserRegistrationDao;
import Com.ttn.Domains.User;
import Com.ttn.Services.ServiceInterfaces.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationServiceImp implements UserRegistrationService {
    @Autowired
    UserRegistrationDao userRegistrationDao;
    public String userRegistration(User user) {
      return userRegistrationDao.registerUser(user);
    }
}
