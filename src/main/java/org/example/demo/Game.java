package org.example.demo;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Game  {

    LoadingImages loadingImages = new LoadingImages();

    public void start(Stage primaryStage) {
        Pane root = new Pane();
        loadingImages.storeClothes();

        loadingImages.setMenu(root);


        loadingImages.changeBackground(root);

        Scene scene = new Scene(root, 1000, 600);
        root.setBackground(loadingImages.bg1);

        primaryStage.setTitle("Fashion Doll");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


