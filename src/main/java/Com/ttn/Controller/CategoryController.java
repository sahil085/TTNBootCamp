package Com.ttn.Controller;

import Com.ttn.Domains.Category;
import Com.ttn.Domains.User;

import Com.ttn.Services.ServiceInterfaces.CategoryOperationsService;
import Com.ttn.Services.ServiceInterfaces.UserOperations;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class CategoryController {
    @Autowired
    CategoryOperationsService categoryOperationsService;
    @Autowired
    UserOperations userOperations;

    @RequestMapping(value = "/addCategory",method = RequestMethod.POST)
    public @ResponseBody String addCategory(@ModelAttribute Category category, HttpSession session)
    {
        category.setUser((User)session.getAttribute("user"));
        return categoryOperationsService.addCategory(category);

    }
    @RequestMapping(value = "/updateCategory",method = RequestMethod.POST)
    public @ResponseBody String updateCategory(@ModelAttribute Category category)
    {
         return categoryOperationsService.updateCategoryDetails(category);
    }

    @RequestMapping(value = "/deleteCategory",method = RequestMethod.POST)
    public @ResponseBody String deleteCategory(@RequestParam("id") long id)
    {
        return categoryOperationsService.deleteCategory(id);
    }
}
