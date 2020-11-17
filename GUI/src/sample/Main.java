package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static final double startHeight = 290, minHeight = 350, minWidth = 830;
    private static final double splitPaneSeparatorMinHeight = 0.65;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        root.setTop(menuLoader.load());
        MenuController menuController = menuLoader.getController();
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("editingPage.fxml"));
        root.setCenter(listLoader.load());
        ListController listController = listLoader.getController();
    
        /*
    
        FXMLLoader editorLoader = new FXMLLoader(getClass().getResource("editor.fxml"));
        root.setRight(editorLoader.load());
        EditorController editorController = editorLoader.getController();
    
        
    
        
        listController.initModel(model);
        editorController.initModel(model);
        */
        /**/
    
        DataModel model = new DataModel();
        
        menuController.initModel(model);
        listController.initModel(model, splitPaneSeparatorMinHeight);
    
        Scene scene = new Scene(root, minWidth, startHeight);
        primaryStage.setMinWidth(minWidth);
        primaryStage.setMinHeight(minHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sessioni studio");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
