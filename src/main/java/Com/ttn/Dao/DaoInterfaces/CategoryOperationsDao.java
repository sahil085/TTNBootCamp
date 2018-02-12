package Com.ttn.Dao.DaoInterfaces;


import Com.ttn.Domains.Category;

import Com.ttn.Domains.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryOperationsDao {
    boolean addCategory(Category category);
    Category getCategoryByname(String categoryName);
    List<Category> getCategoryNamesByUser(User user);
    boolean updateCategoryDetails(Category category);
    boolean deleteCategory(long id);
}
