package sample;

import controller.InputGridController;
import controller.MenuController;
import controller.SessionListViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.DataModel;
import model.Session;

public class Main extends Application {
    private static final double startHeight = 400, minHeight = 350, minWidth = 830;
    private static final double splitPaneSeparatorMinHeight = 0.65;//TODO remove me(?)
    private static final int tabsNumber = 2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
    
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
        root.setTop(menuLoader.load());
        MenuController menuController = menuLoader.getController();
    
        BorderPane sessionsEditor = new BorderPane();
        
        FXMLLoader inputGridLoader = new FXMLLoader(getClass().getResource("/sessionsInputGrid.fxml"));
        ListView<Session> sessionListView = new ListView<Session>();
        SessionListViewController sessionsListViewController = new SessionListViewController(sessionListView);
        sessionsEditor.setTop(inputGridLoader.load());
        sessionsEditor.setCenter(sessionListView);
        InputGridController inputGridController = inputGridLoader.getController();
        
        Tab[] tabs = new Tab[tabsNumber];
        tabs[0] = new Tab("Sessions editor", sessionsEditor);
        tabs[1] = new Tab("Second tab");
        root.setCenter(new TabPane(tabs));
    
        DataModel model = new DataModel();
        menuController.initModel(model);
        sessionsListViewController.initModel(model);
        inputGridController.initModel(model, sessionListView);
    
        Scene scene = new Scene(root, minWidth, startHeight);
        primaryStage.setMinWidth(minWidth);
        primaryStage.setMinHeight(minHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sessioni studio");
        primaryStage.show();
        /*
        BorderPane root = new BorderPane();
        
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        root.setTop(menuLoader.load());
        MenuController menuController = menuLoader.getController();
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("editingPage.fxml"));
        root.setCenter(listLoader.load());
        SessionsFileController listController = listLoader.getController();*/
    
        /*      QUESTA PARTE ERA COMMENTATA
    
        FXMLLoader editorLoader = new FXMLLoader(getClass().getResource("editor.fxml"));
        root.setRight(editorLoader.load());
        EditorController editorController = editorLoader.getController();
    
        
    
        
        listController.initModel(model);
        editorController.initModel(model);
        */
        /**/
    
        /*DataModel model = new DataModel();
        
        menuController.initModel(model);
        listController.initModel(model, splitPaneSeparatorMinHeight);
    
        Scene scene = new Scene(root, minWidth, startHeight);
        primaryStage.setMinWidth(minWidth);
        primaryStage.setMinHeight(minHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sessioni studio");
        primaryStage.show();*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
