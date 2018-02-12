package Com.ttn.Services.ServiceClasses;

import Com.ttn.Dao.DaoInterfaces.UserOperationsDao;
import Com.ttn.Domains.User;
import Com.ttn.Services.ServiceInterfaces.UserOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseroperationsServiceImp implements UserOperations {
    @Autowired
    UserOperationsDao userOperationsDao;
    public User getUserByName(String userName) {
       return userOperationsDao.getUserByName(userName);
    }
}
