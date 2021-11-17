package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    //create a constructor
   /* @Autowired
    public TennisCoach(FortuneService thefortuneService){
        fortuneService=thefortuneService;
    }*/

    //default constructor
    public TennisCoach(){
        System.out.println("Tennis Coach : inside default constructor");
    }

    //define init method
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("Tennis Coach : inside of doMyStartUpStuff");
    }

    //define destroy method
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("Tennis Coach : inside of doMyCleanUpStuff");
    }
    //setter method

    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Tennis Coach : inside setFortuneService() method ");
        this.fortuneService = fortuneService;
    }*/

    /*@Autowired
    public void doCrazyStuff(FortuneService thefortuneService){
        System.out.println("Tennis COach : inside doCrazyStuff() method");
        fortuneService=thefortuneService;
    }*/

    @Override
    public String getDailyWorkOut() {
        return "Pratice for 2 hours Daily";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
