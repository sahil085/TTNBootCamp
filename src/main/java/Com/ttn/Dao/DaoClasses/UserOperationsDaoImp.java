package Com.ttn.Dao.DaoClasses;

import Com.ttn.Dao.DaoInterfaces.UserOperationsDao;

import Com.ttn.Domains.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserOperationsDaoImp implements UserOperationsDao {
    @Autowired
    SessionFactory sessionFactory;
    public User getUserByName(String userName) {
        Session session=sessionFactory.openSession();
        try
        {
            String query="from User where userName=:uname";
            Query query1=session.createQuery(query);
            query1.setParameter("uname",userName);
       User user=   (User)query1.uniqueResult();
            System.out.println("user name" +user.getUserName());
return user;
        }catch (Exception e)
        {
return null;
        }finally {
            session.close();
        }

    }
}
