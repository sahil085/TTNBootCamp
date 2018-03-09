package Controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class StudentController2 extends MultiActionController {

    public ModelAndView index(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg", "Home");
        return model;
    }

    public void hi(HttpServletRequest request,
                   HttpServletResponse response) throws Exception {


        response.getWriter().write("\n" +
                "\n" +
                "\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "Home\n" +
                "</body>\n" +
                "</html>\n");
    }

}
