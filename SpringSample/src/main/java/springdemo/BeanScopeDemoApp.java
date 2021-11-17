package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
        //retrieve bean from spring container
        Coach thecoach = context.getBean("myCoach",Coach.class);
        Coach alphacoach = context.getBean("myCoach",Coach.class);

        // check if they are same
        boolean res= (thecoach==alphacoach);
        System.out.println(res);
        System.out.println("Memory location of theCoach: "+thecoach);
        System.out.println("Memory location of alphaCoach: "+alphacoach);

    }
}
