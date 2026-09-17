package org.ecosystem;

import javafx.scene.layout.Pane;

public class World extends Pane {
    public static final double HEIGHT = 800;
    public static final double WIDTH = 800;

    public World(){
        setPrefSize(HEIGHT, WIDTH);
        setStyle("-fx-background-color: #7CB342;");
    }

}
