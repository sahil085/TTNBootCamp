package Com.ttn.Services.ServiceClasses;

import Com.ttn.Dao.DaoInterfaces.CategoryOperationsDao;
import Com.ttn.Domains.Category;
import Com.ttn.Domains.User;
import Com.ttn.Services.ServiceInterfaces.CategoryOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryOperationsServiceImp implements CategoryOperationsService {
    @Autowired
    CategoryOperationsDao categoryOperationsDao;
    public String addCategory(Category category) {
       if(categoryOperationsDao.addCategory(category))
       {
           return "Category Added Successfully ";
       }else {
           return "Unsuccessfull ";
       }
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryOperationsDao.getCategoryByname(categoryName);

    }

    @Override
    public List<Category> getCategoryNamesByUser(User user) {
        return categoryOperationsDao.getCategoryNamesByUser(user);

    }

    @Override
    public String updateCategoryDetails(Category category) {
        if(categoryOperationsDao.updateCategoryDetails(category))
        {
            return "Category Details Updated Successfully";
        }else {
            return "Category Details Do Not Updated Successfully";
        }
    }

    @Override
    public String deleteCategory(long id) {
        if(categoryOperationsDao.deleteCategory(id))
        {
           return "Category Deleted Successfully";
        }else {
            return "Category Did Not Delete";
        }
    }
}
