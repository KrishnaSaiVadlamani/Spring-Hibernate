package springdemo.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/showForm")
    public String showForm(Model themodel){
        // create a student object
       Student thestudent=new Student();
        // add student object to the model
        themodel.addAttribute("student",thestudent);

        return "student-form";

    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student thestudent){
        System.out.println("theStudent: "+thestudent.getFirstName()+" "
        +thestudent.getLastName());
        return "student-confirmation";
    }
}
