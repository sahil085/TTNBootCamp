package Com.ttn.Services.ServiceClasses;

import Com.ttn.Dao.DaoInterfaces.ContactOperationsDao;
import Com.ttn.Domains.Category;
import Com.ttn.Domains.Contact;
import Com.ttn.Domains.User;
import Com.ttn.Services.ServiceInterfaces.CategoryOperationsService;
import Com.ttn.Services.ServiceInterfaces.ContactOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ContactOperationsServiceImp implements ContactOperationsService {
    @Autowired
    CategoryOperationsService categoryOperationsService;
    @Autowired
    ContactOperationsDao contactOperationsDao;
    @Override
    public String addContact(Contact contact, String[] categoryName) {

       List<Category> categories=new ArrayList<Category>();
       for(int i=0;i<categoryName.length;i++) {
           Category category = categoryOperationsService.getCategoryByName(categoryName[i]);
           categories.add(category);
       }
           contact.setCategories(categories);
           if (contactOperationsDao.addContact(contact)) {
               return "Contact Added Successfully";
           } else {
               return "Contact Did Not Added Successfully";
           }


    }

    @Override
    public List<Contact> getAllContacts(User user) {
      return contactOperationsDao.getAllContacts(user);

    }

    @Override
    public String updateContactDetails(Contact contact, String[] categoryName) {
        List<Category> categories=new ArrayList<Category>();
        for(int i=0;i<categoryName.length;i++) {
            Category category = categoryOperationsService.getCategoryByName(categoryName[i]);
            categories.add(category);
        }
        contact.setCategories(categories);
        if (contactOperationsDao.updateContactDetails(contact)) {
            return "Contact Updated Successfully";
        } else {
            return "Contact Did Not Updated Successfully";
        }

    }

    @Override
    public String deleteContact(long id) {
        if(contactOperationsDao.deleteContact(id))
        {
            return "Contact Deleted SuccessFully";
        }else {
            return "Contact Did not Deleted";
        }
    }
}
