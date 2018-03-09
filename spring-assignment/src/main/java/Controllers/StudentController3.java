package Controllers;

import Beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller

public class StudentController3 {
    @ModelAttribute("heading")
    public String getheading() {
        return "mvc spring demo";
    }

    @RequestMapping(value = "/Student3")
    public ModelAndView render() {
        ModelAndView mav = new ModelAndView("Student3");
        return mav;
    }

    @RequestMapping(value = "/hello")
    public @ResponseBody
    String helloWorld() {

        return "hello world";
    }

    @RequestMapping(value = "/Student5")
    public ModelAndView getModel() {
        ModelAndView mv = new ModelAndView("Student5");
        mv.addObject("msg", "helloworld");
        return mv;
    }

    @RequestMapping(value = "/Student6/{fname}/{lname}")
    public ModelAndView getparam(@PathVariable("fname") String firstname, @PathVariable("lname") String lastname) {
        ModelAndView mav = new ModelAndView("Student6");
        mav.addObject("info", "firstname  is " + firstname + "<br>" + " lastname " + lastname);
        return mav;
    }

    @RequestMapping(value = "/Student/{fname}/{lname}")
    public ModelAndView getparam(@PathVariable("") Map<String, String> pathvar) {
        ModelAndView mav = new ModelAndView("Student6");
        mav.addObject("info", "firstname  is " + pathvar.get("fname") + "<br>" + " lastname " + pathvar.get("lname"));
        return mav;
    }

    @RequestMapping(value = "/Qtn8")
    public ModelAndView getinfo(@RequestParam("fname") String firstname, @RequestParam("lname") String lastname) {
        ModelAndView mav = new ModelAndView("Student6");
        mav.addObject("info", "firstname  is " + firstname + "<br>" + " lastname " + lastname);
        return mav;
    }

    @RequestMapping(value = "/databinding")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "databinding";

    }

    @RequestMapping(value = "/result")
    public ModelAndView getresult(@ModelAttribute Student student) {
        ModelAndView mav = new ModelAndView("Student6");
        mav.addObject("info", " firstname is " + student.getFirstname() + " lastname is " + student.getLastname());
        return mav;
    }

    @RequestMapping(value = "/Qtn10")

    public ModelAndView getHeading(HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("Student6");
        mav.addObject("info", "heading using model attribute");
        return mav;
    }
}
