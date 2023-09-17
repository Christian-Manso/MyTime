/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytime;

/**
 *
 * @author Christian
 */
public class MyTime {
    
    private int hrs;
    private int mins;
    private int secs;
    private boolean meridian;

        public MyTime(){
            hrs=11;
            mins=59;
            secs=35;
            meridian=true;
        }
    
    
    public int getHrs(){
        return hrs;
    }
    public int getMins(){
        return mins;
    }
    public int getSecs(){
        return secs;
    }
    public boolean getMeridian(){
        return this.meridian;
    }
    
    public void setHrs(int newHrs){
        this.hrs = newHrs;
    }
    public void setMins(int newMins){
        this.mins = newMins;
    }
    public void setSecs(int newSecs){
        this.secs = newSecs;
    }
    public void setMeridian(boolean newMeridian){
        this.meridian = newMeridian;
    }
    public String stringMeridian(){
        if (this.getMeridian() == true){
            return "AM";
        }
        else{
            return "PM";
        }
    }
    
    public void advanceTime (int secs){
        this.tickBySecond(secs);
    }
    public void tickBySecond(int secs){
        int minutes;
        int cursecs = this.getSecs();
        cursecs=cursecs+secs;
        for(minutes=0;cursecs>59;cursecs-=60){
            minutes++;
        }
        this.tickByMinute(minutes);
        this.setSecs(cursecs);
    }
    public void tickByMinute(int mins){
        int hour;
        int curmins = this.getMins();
        curmins=curmins+mins;
        for(hour=0;curmins>59;curmins-=60){
            hour++;
        }
        this.tickByHour(hour);
        this.setMins(curmins);
    }
    public void tickByHour(int hrs){       
        int curhrs;
        boolean mer = this.getMeridian();

        for(curhrs= this.getHrs()+hrs;curhrs>=12;curhrs-=12){
            if(mer == true){
                mer=false;
            }
            else{
                mer=true;
            }
        }
        if(curhrs==0){
            curhrs=12;
        }
        this.setHrs(curhrs);
        this.setMeridian(mer);
    }
    
    public void displayTime(){
        System.out.println("The time is: " + this.getHrs() + ":" + this.getMins() + ":" + this.getSecs() + " " + this.stringMeridian());
    }
    
    public void displayMilitaryTime(){
        int hour = this.getHrs();
        if (this.getMeridian() == true){
            if(hour == 12){
                hour=0;
            }
            System.out.println("The time is: " + hour + ":" + this.getMins() + ":" + this.getSecs());
        }
        else{
            if(hour!=12){
            hour+=12;
            }
            System.out.println("The time is: " + hour + ":" + this.getMins() + ":" + this.getSecs());
        }
    }

    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
    MyTime t = new MyTime();
    t.advanceTime(91400);
    t.displayTime();
    t.displayMilitaryTime();
    }
    
}
