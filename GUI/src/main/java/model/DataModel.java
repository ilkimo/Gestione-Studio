package model;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataModel {
    private final ObservableList<Session> sessionsList = FXCollections.observableArrayList(session ->
            new Observable[] {
                session.yearProperty(),
                session.monthProperty(),
                session.dayProperty(),
                session.beginHourProperty(),
                session.beginMinuteProperty(),
                session.endHourProperty(),
                session.endMinuteProperty(),
                session.timerHoursProperty(),
                session.timerMinutesProperty(),
                session.subjectProperty(),
                session.subjectBranchProperty(),
                session.subjectArgumentsListProperty(),
                session.studyGroupProperty(),
                session.placeProperty(),
    });
    
    private final ObjectProperty<Session> currentSession = new SimpleObjectProperty<>(null);
    
    public ObjectProperty<Session> currentSessionProperty() {
        return currentSession ;
    }
    
    public final Session getCurrentSession() {
        return currentSessionProperty().get();
    }
    
    public final void setCurrentSession(Session person) {
        currentSessionProperty().set(person);
    }
    
    public ObservableList<Session> getSessionsList() {
        return sessionsList;
    }
    
    public void clear() {
        sessionsList.clear();
    }
    
    public void addSession(Session s) {
        sessionsList.add(s);
    }
    
    public void loadData(File file, boolean append) {
        Scanner inputStream = null;
        int formatExceptions = 0;
        
        if((!append) && (sessionsList != null)) {
            sessionsList.clear();
        }
        
        try {
            ArrayList<Session> sessions = new ArrayList<Session>();
            inputStream = new Scanner(file);
            
            while(inputStream.hasNextLine()) {
                String formattedString = inputStream.nextLine();
                
                try {
                    sessions.add(new Session(formattedString));
                } catch(Exception e) {
                    formatExceptions++;//TODO do something with me
                }
            }
            
            sessions.sort((Session s1, Session s2) -> {
                int comparison = s1.compareTo(s2);
                
                return (comparison != 0) ? comparison * (-1) : 0;
            });
            
            sessionsList.addAll(sessions);
        } catch(FileNotFoundException e) {
            throw new Error("Error: file not found");
        } catch(IllegalStateException e) {
            throw new Error("Error: file got closed prematurely");
        } catch(Exception e) {
            throw new Error(e.getMessage());
        } finally {
            inputStream.close();
        }
    }
}
