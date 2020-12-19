package controller;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import model.DataModel;
import model.Session;

public class SessionListViewController {
    private ListView<Session> sessionListView;
    
    public SessionListViewController(ListView<Session> sessionListView) {
        this.sessionListView = sessionListView;
    }
    
    public void initModel(DataModel model) {
        sessionListView.setItems(model.getSessionsList());
        
        sessionListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
                model.setCurrentSession(newSelection));
        
        model.currentSessionProperty().addListener((obs, oldPerson, newSession) -> {
            if (newSession == null) {
                sessionListView.getSelectionModel().clearSelection();
            } else {
                sessionListView.getSelectionModel().select(newSession);
            }
        });
        
        sessionListView.setCellFactory(lv -> new ListCell<Session>() {
            @Override
            public void updateItem(Session session, boolean empty) {
                super.updateItem(session, empty);
                if(empty) {
                    setText(null);
                } else {
                    setText(session.toString());
                }
            }
        });
    }
}
