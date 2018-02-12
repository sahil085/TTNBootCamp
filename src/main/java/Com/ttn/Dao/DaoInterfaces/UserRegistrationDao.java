package Com.ttn.Dao.DaoInterfaces;


import Com.ttn.Domains.User;
import org.springframework.stereotype.Component;

@Component
public interface UserRegistrationDao {
    String registerUser(User user);
}
