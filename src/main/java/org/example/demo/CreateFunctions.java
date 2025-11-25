package org.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CreateFunctions {
    //-------------------------------------------------------------//
    public ImageView createImage(String file, int x, int y, int w){
        Image image = new Image(getClass().getResource(file).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitWidth(w);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    public Background createBackground(String file){
        BackgroundSize backgroundSize = new BackgroundSize(
                100, 100,
                true, true,
                true, false
        );


        Image bgImage = new Image(getClass().getResource(file).toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(
                bgImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize
        );

        return new Background(backgroundImage);
    }
    //---------------------------------------------------------------------//


    Rectangle rect1;
    Rectangle rect1_1;
    Rectangle rect2;
    Rectangle rect2_1;
    Rectangle rect3;
    Rectangle rect3_1;
    public Pane menuContent;
    public Pane menuBackground;
    public Pane menuButtons;

    public Pane createMenu(ImageView icon1, ImageView icon2, ImageView icon3) {
        Pane menu = new Pane();

        rect1 = new Rectangle(600, 100, 300, 400);
        rect1.setFill(Color.LIGHTBLUE);
        rect1.setStroke(Color.DARKBLUE);

        rect1_1 = new Rectangle(600, 70, 30, 30);
        rect1_1.setFill(Color.LIGHTBLUE);
        rect1_1.setStroke(Color.DARKBLUE);

        rect2 = new Rectangle(600, 100, 300, 400);
        rect2.setFill(Color.LIGHTGREEN);
        rect2.setStroke(Color.DARKGREEN);

        rect2_1 = new Rectangle(650, 70, 30, 30);
        rect2_1.setFill(Color.LIGHTGREEN);
        rect2_1.setStroke(Color.DARKGREEN);

        rect3 = new Rectangle(600, 100, 300, 400);
        rect3.setFill(Color.LIGHTCYAN);
        rect3.setStroke(Color.DARKCYAN);

        rect3_1 = new Rectangle(700, 70, 30, 30);
        rect3_1.setFill(Color.LIGHTCYAN);
        rect3_1.setStroke(Color.DARKCYAN);

        menuBackground = new Pane(rect1);
        menuButtons = new Pane(rect1_1, rect2_1, rect3_1);
        menuContent = new Pane();

        menu.getChildren().addAll(menuBackground, menuContent, menuButtons, icon1, icon2, icon3);

        return menu;
    }

    public Pane createDoll(ImageView imageView){
        Pane doll = new Pane();
        doll.getChildren().add(imageView);
        return doll;
    }



}
