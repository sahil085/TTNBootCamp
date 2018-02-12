package Com.ttn.Dao.DaoInterfaces;


import Com.ttn.Domains.User;
import org.springframework.stereotype.Component;

@Component
public interface UserOperationsDao {
    User getUserByName(String userName);
}
