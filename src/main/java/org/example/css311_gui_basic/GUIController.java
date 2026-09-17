package org.example.css311_gui_basic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class GUIController {

    @FXML
    private Label nameLabel;

    @FXML
    private Circle circle;

    @FXML
    private Rectangle rectangle;

    // Makes the shapes movable after the FXML loads
    @FXML
    public void initialize() {
        makeDraggable(circle);
        makeDraggable(rectangle);
    }

    // Changes the label when the button is clicked
    @FXML
    private void buttonPressed(ActionEvent event) {
        nameLabel.setText("Welcome to my JavaFX project!");
        nameLabel.setRotate(10);
    }

    // Allows a JavaFX object to be dragged with the mouse
    private void makeDraggable(Node node) {
        final double[] mouseOffset = new double[2];

        // Remember where the mouse was pressed
        node.setOnMousePressed(event -> {
            mouseOffset[0] =
                    event.getSceneX() - node.getTranslateX();

            mouseOffset[1] =
                    event.getSceneY() - node.getTranslateY();

            node.setCursor(javafx.scene.Cursor.CLOSED_HAND);
        });

        // Move the shape as the mouse is dragged
        node.setOnMouseDragged(event -> {
            node.setTranslateX(
                    event.getSceneX() - mouseOffset[0]
            );

            node.setTranslateY(
                    event.getSceneY() - mouseOffset[1]
            );
        });

        // Restore the cursor when dragging ends
        node.setOnMouseReleased(event ->
                node.setCursor(javafx.scene.Cursor.HAND)
        );

        node.setCursor(javafx.scene.Cursor.HAND);
    }
}