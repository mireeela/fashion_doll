package org.example.demo;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class DragDropLogic {

    private double offsetX, offsetY;
    private double originalX, originalY;

    public boolean isNear(ImageView clothing, Node doll) {
        Bounds clothingBounds = clothing.getBoundsInParent();
        Bounds dollBounds = doll.getBoundsInParent();
        return clothingBounds.intersects(dollBounds);
    }

    private boolean draggingEnabled = true;

    public void setDraggingEnabled(boolean enabled) {
        this.draggingEnabled = enabled;
    }


    public void dragdrop(Pane pane, ImageView draggable, Pane menuContent) {
        ImageView target = (ImageView) pane.getChildren().getFirst();

        originalX = draggable.getLayoutX();
        originalY = draggable.getLayoutY();

        draggable.setOnMousePressed(e -> {
            if (!draggingEnabled) return;

            offsetX = e.getSceneX() - draggable.getLayoutX();
            offsetY = e.getSceneY() - draggable.getLayoutY();

            Pane currentParent = (Pane) draggable.getParent();
            if(currentParent != pane){
                pane.toBack();
            } else if (currentParent != menuContent) {
                pane.toFront();
            }

        });

        draggable.setOnMouseDragged(e -> {
            if (!draggingEnabled) return;

            draggable.setLayoutX(e.getSceneX() - offsetX);
            draggable.setLayoutY(e.getSceneY() - offsetY);



        });
        draggable.setOnMouseReleased(e -> {
            if (!draggingEnabled) return;

            pane.toFront();

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

