package org.ecosystem;

import javafx.scene.layout.Pane;

public class Ecosystem {
    private final World world;
    private final Rabbit rabbit;

    public Ecosystem(){
        world = new World();
        rabbit = new Rabbit(400,300);
        world.getChildren().add(rabbit.getGraphic());
    }

    public void update(){
        rabbit.move();
    }
    public Pane getWorld(){
        return world;
    }

}
