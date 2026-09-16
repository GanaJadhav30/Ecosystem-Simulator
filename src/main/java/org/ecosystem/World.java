package org.ecosystem;

import javafx.scene.layout.Pane;

public class World extends Pane {
    public static final double length = 800;
    public static final double width = 800;

    public World(){
        setPrefSize(length,width);
        setStyle("-fx-background-color: #7CB342;");
    }

}
