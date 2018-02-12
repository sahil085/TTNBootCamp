package Com.ttn.Dao.DaoInterfaces;

import Com.ttn.Domains.Contact;
import Com.ttn.Domains.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContactOperationsDao {
    boolean addContact(Contact contact);
    List<Contact> getAllContacts(User user);
    boolean updateContactDetails(Contact contact);
    boolean deleteContact(long id);
}
