package Com.ttn.Dao.DaoClasses;



import Com.ttn.Dao.DaoInterfaces.CategoryOperationsDao;
import Com.ttn.Domains.Category;

import Com.ttn.Domains.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryOperationsDaoImp implements CategoryOperationsDao {
    @Autowired
    SessionFactory sessionFactory;
    public boolean addCategory(Category category) {
        Session session=sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            session.save(category);
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
    public Category getCategoryByname(String categoryName) {
        Session session=sessionFactory.openSession();
        try
        {
            String q="from Category where categoryName=:cname";
            Query query=session.createQuery(q);
            query.setParameter("cname",categoryName);
            return (Category)query.uniqueResult();


        }catch (Exception e)
        {
            System.out.println("error "+e);
            return null;

        }finally {
            session.close();
        }

    }

    @Override
    public List<Category> getCategoryNamesByUser(User user) {
        Session session=sessionFactory.openSession();
        try
        {
            String q="from Category where user.userName=:uname";
            Query query=session.createQuery(q);
            query.setParameter("uname",user.getUserName());
            return query.list();

        }catch (Exception e)
        {
            System.out.println("error "+e);
            return null;

        }finally {
            session.close();
        }
    }

    @Override
    public boolean updateCategoryDetails(Category category) {
        Session session=sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Category category1= (Category) session.get(Category.class,category.getId());
            category1.setCategoryName(category.getCategoryName());
            session.saveOrUpdate(category1);
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
    public boolean deleteCategory(long id) {
        Session session=sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Category category= (Category) session.get(Category.class,id);
            session.delete(category);
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
}
