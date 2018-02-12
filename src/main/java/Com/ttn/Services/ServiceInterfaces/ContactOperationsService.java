package Com.ttn.Services.ServiceInterfaces;

import Com.ttn.Domains.Contact;
import Com.ttn.Domains.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactOperationsService {
    String addContact(Contact contact,String[] categoryName);
    List<Contact> getAllContacts(User user);
    String updateContactDetails(Contact contact,String[] categoryName);
    String deleteContact(long id);
}
