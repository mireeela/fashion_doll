package org.example.demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Game  {

    LoadingImages loadingImages = new LoadingImages();

    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(1000, 600);
        root.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        root.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        loadingImages.setMenu(root);


        StackPane outer = new StackPane(root);
        StackPane.setAlignment(root, Pos.CENTER);

        Scene scene = new Scene(outer);

        loadingImages.changeBackground(outer);
        outer.setBackground(loadingImages.bg1);


        primaryStage.setTitle("Fashion Doll");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


