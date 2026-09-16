package org.ecosystem;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {

    @Override
    public void start(Stage stage){

        //Create Ecosystem
        Ecosystem ecosystem = new Ecosystem();


        //create ecosystem loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                ecosystem.update();
            }
        };

        timer.start();

        Scene scene = new Scene(ecosystem.getWorld(),World.width,World.length);
        stage.setTitle("Ecosystem Simulator");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}