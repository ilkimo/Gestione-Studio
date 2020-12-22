package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.DataModel;
import model.Session;
import model.TMPSession;

import java.util.ArrayList;

public class InputGridController {
    DataModel model;
    ListView<Session> sessionListView;
    TMPSession buildingSession;
    
    @FXML
    private Text displayTimer;
    
    @FXML
    private Button buttonSTART;
    
    @FXML
    private Button buttonSTOP;
    
    @FXML
    private TextField fieldStartTime;
    
    @FXML
    private TextField fieldEndTime;
    
    @FXML
    private TextField fieldDate;
    
    @FXML
    private TextField fieldSubject;
    
    @FXML
    private TextField fieldBranch;
    
    @FXML
    private TextField fieldArgsList;
    
    @FXML
    private TextField fieldPlace;
    
    @FXML
    private TextField fieldPeople;
    
    @FXML
    private Button ButtonNewSession;
    
    public void initModel(DataModel model, ListView<Session> sessionListView) {
        this.sessionListView = sessionListView;
        this.model = model;
        startNewSession();
    }
    
    private void startNewSession() {
        if(buildingSession != null) {
            displayTimer.textProperty().unbind();
        }
    
        this.buildingSession = new TMPSession();
        displayTimer.textProperty().bind(buildingSession.getRecordedTimeProperty());
    }
    
    @FXML
    private void handleButtonStart() {
        if(buildingSession == null) {
            //TODO, non so nemmeno se l'if serva a qualcosa
        }
        
        buildingSession.startTimer();
    }
    
    @FXML
    private void handleButtonStop() {
        //TODO
    
        buildingSession.stopTimer();
    }
    
    @FXML
    private void handleNewSessionButton() {
        Session s;
        
        System.out.println("New session button: path not programmed yet!");
        System.out.println("start time: " + fieldStartTime.getText());
        System.out.println("end time: " + fieldEndTime.getText());
        System.out.println("date: " + fieldDate.getText());
        System.out.println("subject: " + fieldSubject.getText());
        System.out.println("branch: " + fieldBranch.getText());
        System.out.println("args list: " + fieldArgsList.getText());
        System.out.println("place: " + fieldPlace.getText());
        System.out.println("people: " + fieldPeople.getText());
    
        try {
            //s = new Session();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}