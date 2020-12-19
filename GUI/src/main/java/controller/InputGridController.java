package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.DataModel;
import model.Session;

public class InputGridController {
    DataModel model;
    ListView<Session> sessionListView;
    
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
    
    public void initModel(DataModel model, ListView<Session> sessionListView) {
        this.sessionListView = sessionListView;
        this.model = model;
    }
}
