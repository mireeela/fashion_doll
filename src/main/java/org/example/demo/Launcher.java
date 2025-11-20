package org.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher  extends Application{
    Game game = new Game();

    @Override
    public void start(Stage stage)  {
        game.start(stage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
