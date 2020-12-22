package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TMPSession {
    public enum timerState {ZERO, RUNNING, STOPPED};
    
    Timer timer;
    
    public TMPSession() {
        timer = new Timer();
    }
    
    public StringProperty getRecordedTimeProperty() { return timer.getRecordedTimeProperty(); }
    
    public void startTimer() {
        timer.start();
    }
    
    public void stopTimer() {
        timer.stop();
    }
    
    class Timer {
        private timerState timerState;
        StringProperty recordedTime = new SimpleStringProperty();
        
        public Timer() {
            timerState = timerState.ZERO;
            recordedTime.set("00:00:00");
        }
        
        public timerState getTimerState() { return timerState; }
        
        public void setTimerState(timerState newState) {
            timerState = newState;
        }
        
        public StringProperty getRecordedTimeProperty() { return recordedTime; }
    
        public void start() {
            //TODO
            
            switch(timer.getTimerState()) {
                case ZERO -> { System.out.println("ZERO --> RUNNING"); }
                case RUNNING -> { System.out.println("RUNNING"); }
                case STOPPED -> { System.out.println("STOPPED --> RUNNING"); }
            }
        
            timer.setTimerState(timerState.RUNNING);
        }
    
        public void stop() {
            //TODO
        
            switch(timer.getTimerState()) {
                case ZERO -> { System.out.println("ZERO"); }
                case STOPPED -> { System.out.println("STOPPED"); }
                case RUNNING -> {
                    timer.setTimerState(timerState.STOPPED);
                    System.out.println("RUNNING --> STOPPED");
                }
            }
        }
    }
}


/*

import javax.swing.Timer;
      Timer  timer=new Timer(1000,new ActionListener(){
         public void actionPerformed(ActionEvent e)
     {
        //code here
     }
     });
     timer.start();
    //timer.stop()

* */