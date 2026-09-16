package org.ecosystem;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Ecosystem {
    private final World world;
    private final List<Animal> animals;

    public Ecosystem(){
        world = new World();
        animals = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            double x = Math.random()*World.width;
            double y = Math.random()*World.length;

            Rabbit rabbit = new Rabbit(x,y);
            animals.add(rabbit);
            world.getChildren().add(rabbit.getGraphic());
        }

    }

    public void update(){
        for(Animal animal: animals){
            animal.move();
        }
    }
    public Pane getWorld(){
        return world;
    }

}
