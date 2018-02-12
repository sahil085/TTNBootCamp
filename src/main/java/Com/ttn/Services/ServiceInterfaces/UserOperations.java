package Com.ttn.Services.ServiceInterfaces;


import org.springframework.stereotype.Service;
import Com.ttn.Domains.User;

@Service
public interface UserOperations {
    User getUserByName(String userName);
}
