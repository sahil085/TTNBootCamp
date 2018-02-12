package Com.ttn.Services.ServiceInterfaces;

import Com.ttn.Domains.User;
import org.springframework.stereotype.Service;

@Service
public interface UserRegistrationService {
    String userRegistration(User user);

}
