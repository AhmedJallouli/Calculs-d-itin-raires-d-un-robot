package controllers;

import Grid.GridManager;
import Grid.SetupGridNodes;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class StartController {

    private static final int MIN_VALUE = 4;
    private static final int MAX_VALUE = 20;
    private static final double CELL_SIZE = 100;
    private double xOffset = 0;
    private double yOffset = 0;
    public static Scene scene;
    public static final GridManager gridManager = new GridManager();

    @FXML
    private Button closeButton;
    @FXML
    private TextField width;
    @FXML
    private TextField height;

    @FXML
    private void close() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirm() throws IOException {
        if (isInputValid(width) && isInputValid(height)) {
            int widthValue = (Integer.parseInt(width.getText()));
            int heightValue = (Integer.parseInt(height.getText()));
            System.out.println("K");

            Parent root = FXMLLoader.load(getClass().getResource("../views/grid.fxml"));

            Stage stage = (Stage) closeButton.getScene().getWindow();
            gridManager.makeGrid(CELL_SIZE, heightValue, widthValue, 20);

            scene = new Scene(root, CELL_SIZE * widthValue + 40, CELL_SIZE * heightValue + 96);
            VBox vbox = (VBox) scene.lookup("#vbox");
            vbox.getChildren().add(gridManager.getGrid());
            new SetupGridNodes(gridManager);
            stage.setScene(scene);
            stage.show();

            //make the window movable
           /* root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            root.setOnMouseDragged(new EventHandler<>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });*/

        } else System.out.println("ERR");
    }

    // Validates the user input.
    private boolean isInputValid(TextField t) {
        boolean b = false;
        if (!(t.getText() == null || t.getText().length() == 0)) {
            try {
                int d = Integer.parseInt(t.getText());
                if (MIN_VALUE <= d && d <= MAX_VALUE) {
                    b = true;
                } else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Input Error");
                    alert.setContentText("Must be between 4 and 20");

                    alert.showAndWait();
                    System.out.println("Must be between 4 and 20");
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Input Error");
                alert.setContentText("Must be a number");

                alert.showAndWait();
            }
        }
        return b;
    }

}
