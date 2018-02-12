package Com.ttn.Services.ServiceInterfaces;

import Com.ttn.Domains.Category;
import Com.ttn.Domains.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryOperationsService {
    String addCategory(Category category);
    Category getCategoryByName(String categoryName);
    List<Category> getCategoryNamesByUser(User user);
    String updateCategoryDetails(Category category);
    String deleteCategory(long id);
}
