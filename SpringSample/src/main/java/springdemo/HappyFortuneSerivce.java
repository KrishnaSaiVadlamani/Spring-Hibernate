package springdemo;

class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune(){
        return "Today is a very Lucky day for you";
    }
}
