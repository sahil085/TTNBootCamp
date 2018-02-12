package Com.ttn.Dao.DaoClasses;

import Com.ttn.Dao.DaoInterfaces.ContactOperationsDao;
import Com.ttn.Domains.Contact;
import Com.ttn.Domains.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactOperationsDaoImp implements ContactOperationsDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public boolean addContact(Contact contact) {
        Session session=sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            session.save(contact);
            session.getTransaction().commit();
            return true;

        }catch (Exception e)
        {
            return false;
        }finally {
            session.close();
        }

    }

    @Override
    public List<Contact> getAllContacts(User user) {
        Session session=sessionFactory.openSession();
        try
        {
            String q="from Contact WHERE createdBy.userName=:uname";
            Query query=session.createQuery(q);
            query.setParameter("uname",user.getUserName());
             List<Contact> list=query.list();
             for (Contact con:list)
             {
                 System.out.println(" list of contact "+con.getName());
             }
            return list;

        }catch (Exception e)
        {
            System.out.println("error "+e);
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean updateContactDetails(Contact contact) {
        Session session=sessionFactory.openSession();
        try
        {
            session.beginTransaction();
          Contact contact1= (Contact) session.get(Contact.class,contact.getId());
           contact1.setCreatedBy(contact.getCreatedBy());
           contact1.setCategories(contact.getCategories());
           contact1.setCompany(contact.getCompany());
           contact1.setEmailId(contact.getEmailId());
           contact1.setName(contact.getName());
           contact1.setPhoneNo(contact.getPhoneNo());
            session.merge(contact1);
            session.getTransaction().commit();
            return true;

        }catch (Exception e)
        {
            System.out.println("error "+e);
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean deleteContact(long id) {
        Session session=sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Contact contact= (Contact) session.get(Contact.class,id);
            session.delete(contact);
            session.getTransaction().commit();
            return true;

        }catch (Exception e)
        {
            System.out.println("error "+e);
            return false;

        }
    }
}
