package org.ecosystem;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage){
        World world = new World();
        Rabbit rabbit = new Rabbit(400,300);
        world.getChildren().add(rabbit.getGraphic());

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                rabbit.move();
            }
        };

        timer.start();

        Scene scene = new Scene(world,World.width,World.length);
        stage.setTitle("Ecosystem Simulator");
        stage.setScene(scene);
        stage.show();
    }
}