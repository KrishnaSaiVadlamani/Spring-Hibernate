package springdemo;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;
    //add new field for emailAddress and team
    private String emailAddress;
    private String team;
    //create a non-argument constructor
    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    //create a setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - setTeam");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Batting atleast an hour daily";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
