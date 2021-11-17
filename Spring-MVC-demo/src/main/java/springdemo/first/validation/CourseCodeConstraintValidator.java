package springdemo.first.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {


    private String coursePrefix;
    @Override
    public void initialize(CourseCode theCourseCode) {
       coursePrefix=theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean res;
        if(theCode!=null) {
            res = theCode.startsWith(coursePrefix);
        }else {
            res=true;
        }
        return res;
    }
}
