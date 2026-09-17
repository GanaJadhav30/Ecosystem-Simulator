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
            double x = Math.random()*World.WIDTH;
            double y = Math.random()*World.HEIGHT;

            Rabbit rabbit = new Rabbit(x,y);
            animals.add(rabbit);
            world.getChildren().add(rabbit.getGraphic());
        }

        //create plants
        for (int i = 0; i < 50; i++) {
            double x = Math.random()*World.WIDTH;
            double y = Math.random()*World.HEIGHT;

            //spawn plant slightly away from wall
            if(x<5){
                x=10;
            }
            if(x>World.WIDTH-5){
                x = World.WIDTH-10;
            }
            if(y<5){
                y=10;
            }
            if(y>World.HEIGHT-5){
                y = World.HEIGHT-10;
            }

            Plant plant = new Plant(x,y);
            plants.add(plant);
            world.getChildren().add(plant.getGraphic());
        }

    }


    public void update(){
        for(Animal animal: animals){
            if(animal instanceof Rabbit rabbit){
                rabbit.update(plants);
            }
        }
    }
    public Pane getWorld(){
        return world;
    }

}
