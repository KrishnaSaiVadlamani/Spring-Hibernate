package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
        //get the bean from spring container
        SwimCoach thecoach=context.getBean("swimCoach",SwimCoach.class);
        //call a method on the bean
        System.out.println(thecoach.getDailyWorkOut());

        // call method to get the daily fortune
        System.out.println(thecoach.getDailyFortune());

        // call our new swim coach methods...has the props values injected
        System.out.println("Email : "+thecoach.getEmail());
        System.out.println("Team : "+thecoach.getTeam());
        // close the context
        context.close();
    }
}
