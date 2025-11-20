package org.example.demo;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.geometry.Point2D;
import java.util.ArrayList;

public class DragDropLogic {

    private double offsetX, offsetY;
    private double originalX, originalY;

    public boolean isNear(ImageView clothing, Node doll) {
        Bounds clothingBounds = clothing.getBoundsInParent();
        Bounds dollBounds = doll.getBoundsInParent();
        return clothingBounds.intersects(dollBounds);
    }

    public void dragdrop(Pane pane, ImageView draggable, Pane menuContent) {
        ImageView target = (ImageView) pane.getChildren().getFirst();

        originalX = draggable.getLayoutX();
        originalY = draggable.getLayoutY();

        draggable.setOnMousePressed(e -> {

            offsetX = e.getSceneX() - draggable.getLayoutX();
            offsetY = e.getSceneY() - draggable.getLayoutY();

        });
        draggable.setOnMouseDragged(e -> {
            draggable.setLayoutX(e.getSceneX() - offsetX);
            draggable.setLayoutY(e.getSceneY() - offsetY);

        });
        draggable.setOnMouseReleased(e -> {
            Pane currentParent = (Pane) draggable.getParent();

            if (isNear(draggable, target)) {

                if (currentParent != pane) {
                    currentParent.getChildren().remove(draggable);
                    pane.getChildren().add(draggable);
                }

                draggable.toFront();

                draggable.setLayoutX(target.getLayoutX());
                draggable.setLayoutY(target.getLayoutY());
                draggable.setFitWidth(380);


            } else {
                if (currentParent != menuContent) {
                    currentParent.getChildren().remove(draggable);
                    menuContent.getChildren().add(draggable);
                }

                draggable.toFront();

                draggable.setLayoutX(originalX);
                draggable.setLayoutY(originalY);
                draggable.setFitWidth(180);


            }

        });
    }




}

