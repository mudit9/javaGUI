import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Animal {
    private String animalID;
    private String Type;
  /*  public int cageNO;
    public String medications;
    public String allergies;
        public int alarmTime;
    public String trainers;*/
    public String status;
    public int foodquantity;
    public static String[] statuses = {"Strolling","Playing","Studying"};
    public int feed()
    {   if(foodquantity<50) {
        this.foodquantity = this.foodquantity + 50;
        return this.foodquantity;
    }
        else {
        this.foodquantity = 100;
        return this.foodquantity;
        }
    }
    Animal(String x,String y, int z,String t)
    {
        animalID = x;
        status = y;
        foodquantity = z;
        Type = t;
    }
    public String getStatus()
    {
        if(this.foodquantity<=30)
            return "hungry";
        else {
            Random ran = new Random();
            int xa = ran.nextInt(3);
            return statuses[xa];
        }
    }
    public String getanimalID()
    {
        return this.animalID;
    }
    public String getType()
    {
        return this.Type;
    }
    public void eat() throws InterruptedException {

       // while(this.foodquantity>0) {
           // long t= System.currentTimeMillis();
           // long end = t+15000;

        }
    //}

    public void checkStatus()
    {

    }

}

