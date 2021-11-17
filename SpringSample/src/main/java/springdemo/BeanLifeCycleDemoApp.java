package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
        //retrieve bean from spring container
        Coach thecoach = context.getBean("myCoach",Coach.class);
        System.out.println(thecoach.getDailyWorkout());
        //close the context
        context.close();

    }
}
