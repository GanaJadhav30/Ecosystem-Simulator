package org.ecosystem;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Ecosystem {
    private final World world;
    private final List<Animal> animals;
    private final List<Plant> plants;

    public Ecosystem(){
        world = new World();
        animals = new ArrayList<>();
        plants = new ArrayList<>();
        //creates rabbit
        for (int i = 0; i < 20; i++) {
            double x = Math.random()*World.width;
            double y = Math.random()*World.length;

            Rabbit rabbit = new Rabbit(x,y);
            animals.add(rabbit);
            world.getChildren().add(rabbit.getGraphic());
        }

        //create plants
        for (int i = 0; i < 50; i++) {
            double x = Math.random()*World.width;
            double y = Math.random()*World.length;

            Plant plant = new Plant(x,y);
            plants.add(plant);
            world.getChildren().add(plant.getGraphic());
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
