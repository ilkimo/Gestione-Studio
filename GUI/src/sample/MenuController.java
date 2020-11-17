package sample;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.File;

public class MenuController {
    private DataModel model;
    
    @FXML
    private MenuBar menuBar;
    
    public void initModel(DataModel model) {
        this.model = model ;
    }
    
    @FXML
    public void load() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(menuBar.getScene().getWindow());
        
        if(file != null) {
            
            try {
                model.loadData(file, false);
            } catch (Exception exc) {
                // handle exception...
            }
        }
    }
}
