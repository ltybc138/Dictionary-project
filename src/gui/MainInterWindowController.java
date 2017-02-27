package gui;

import database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class MainInterWindowController {
    // connect to database form
    @FXML
    private TextField urlTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label connectLog;
    @FXML
    private Button connectButton;
    private String databaseUrl;
    private String databaseName;
    private String databasePassword;

    // open database form
    @FXML
    private TextField pathTextField;
    @FXML
    private Button openButton;
    private String path;

    // Connection vars
    private boolean isConnected = false;

    @FXML
    public void connectAction() {
        connectButton.setOnAction(e -> {

            if (!isConnected) {
                Database database = Database.getInstance();
                isConnected = database.connectToDatabase("TEST2", "root", "password");
            }

            if (isConnected) {
                connectLog.setTextFill(Color.GREEN);
                connectLog.setText("Connected");
            } else {
                connectLog.setTextFill(Color.RED);
                connectLog.setText("Fail to connect");
            }
        });
    }

    @FXML
    public void openAction() {
        openButton.setOnAction(e -> {
            this.path = pathTextField.getText().trim();
            System.out.println("Opened");
        });
    }

}
