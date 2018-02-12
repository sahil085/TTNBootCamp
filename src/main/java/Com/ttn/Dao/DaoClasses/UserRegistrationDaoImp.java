package Com.ttn.Dao.DaoClasses;

import Com.ttn.Dao.DaoInterfaces.UserRegistrationDao;

import Com.ttn.Domains.User;
import Com.ttn.Services.ServiceInterfaces.UserOperations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDaoImp implements UserRegistrationDao {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    UserOperations userOperations;

    public String registerUser(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            user.setEnabled(true);
            user.setAuthorities("USER");
//            String encodedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
//            user.setPassword(encodedPassword);
            session.save(user);
            session.getTransaction().commit();


            return "Registered Successfully";

        } catch (Exception e) {
            System.out.printf("Error In User Registration Dao " + e);
            return "Try Again";
        } finally {
            session.close();
        }
    }
}
