import database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Utils;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;
    private Scene scene;
    private VBox pane;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        try {
            pane = FXMLLoader.load(Main.class.getResource("MainInterWindow.fxml"));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Dictionary project 0.0.1v");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
        //Database.getInstance().connectToDatabase("TEST2","root", "password");
        //Database.getInstance().addWord("end", "rus", "apple", "яблоко", "n");
        //Database.getInstance().updateQuery(Utils.readTextFromFile("start_query.sql"));
    }
}
