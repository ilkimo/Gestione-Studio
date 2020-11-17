package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;

public class ListController {
    private DataModel model;
    
    @FXML
    private SplitPane splitPane;
    
    @FXML
    private ListView<Session> listView;
    
    public void initModel(DataModel model, double splitPaneSeparatorMinHeight) {
        this.model = model ;
    
        splitPane.setDividerPosition(0, splitPaneSeparatorMinHeight);
        
        listView.setItems(model.getSessionsList());
        
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
                model.setCurrentSession(newSelection));
        
        model.currentSessionProperty().addListener((obs, oldPerson, newSession) -> {
            if (newSession == null) {
                listView.getSelectionModel().clearSelection();
            } else {
                listView.getSelectionModel().select(newSession);
            }
        });
        
        listView.setCellFactory(lv -> new ListCell<Session>() {
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
