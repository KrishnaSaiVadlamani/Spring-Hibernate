package springdemo.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/hello")  //parent mapping
public class HelloWorldController {

    // need a controller method to show initial HTML form

    @RequestMapping("/showForm")   // sub mappings
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }


    //new  controller method to read form data and add
    //data to model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
       //read the request parameter from the html form
        String theName=request.getParameter("studentName");
        //convert the data to all caps
        theName=theName.toUpperCase();
        //create the message
        String res="Yo! "+theName;
        //add message to the model
        model.addAttribute("message",res);
        return "helloworld";
    }


    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,
                                          Model model){

        //convert the data to all caps
        theName=theName.toUpperCase();
        //create the message
        String res="Hey How are You? "+theName;
        //add message to the model
        model.addAttribute("message",res);
        return "helloworld";
    }
}
