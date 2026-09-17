package org.ecosystem;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Animal{

    private final Circle graphic;

    private final double SPEED = 1.5;
    private final double EATING_DISTANCE=5;
    private final double MAX_AGE=60;
    private final double MAX_ENERGY=100;
    private double reproductionCooldown=0;

    public Rabbit(double x, double y) {
        super(x, y);
        graphic = new Circle(10);
        graphic.setFill(Color.WHITE);
        updateGraphic();
    }

    @Override
    public void move() {

    }


    //calculates distance between  rabbit and one plant
    private double distanceTo(Plant plant){
        double dx = plant.getX()-x;
        double dy = plant.getY()-y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    //find the nearest plant
    private Plant findNearestplant(List<Plant> plants){
        Plant nearest = null;
        double nearestDistance = Double.MAX_VALUE;
        for(Plant plant : plants){
            double distance = distanceTo(plant);
            if(distance<nearestDistance){
                nearestDistance = distance;
                nearest = plant;
            }
        }
        return nearest;
    }

    //move rabbit to nearest plant
    private void moveToward(Plant plant){
        double dx = plant.getX()-x;
        double dy = plant.getY()-y;

        double distance = Math.sqrt(dx*dx + dy*dy);
        if(distance>0){
            x = x + (dx/distance)*SPEED;
            y = y + (dy/distance)*SPEED;
        }
        keepInsideWorld();
    }
    //random movement of rabbit
    private void randomMovement(){
        x = x + Math.random()*2-1;
        y = y + Math.random()*2-1;
        keepInsideWorld();
    }
    //keep rabbit from going outside
    private void keepInsideWorld(){
        //left wall
        if (x < 10) {
            x = 10;
        }
        //right wall
        if (x > World.WIDTH -10) {
            x = World.WIDTH -10;
        }
        //top wall
        if (y < 10) {
            y = 10;
        }
        //bottom wall
        if (y > World.HEIGHT -10) {
            y = World.HEIGHT -10;
        }
    }
    //rabbit eats plants
    private void eat(Plant plant,List<Plant> plants){
        energy = energy+ plant.getEnergy();
        plants.remove(plant);
        plant.getGraphic().setVisible(false);
    }

    public void update(List<Plant> plants){
        age = age+0.016;
        if(energy>80){
            reproduce();
        }
        if(reproductionCooldown>0){
            reproductionCooldown -= 0.016;
        }
        Plant nearestPlant = findNearestplant(plants);
        if(nearestPlant!=null){
            moveToward(nearestPlant);

            if(distanceTo(nearestPlant)<=EATING_DISTANCE){
                eat(nearestPlant,plants);
            }
        }else{
            randomMovement();
        }
        energy = energy-0.02;
        updateGraphic();
    }

    public Rabbit reproduce(){
        double babyX = x + Math.random()*20-10;
        double babyY = y + Math.random()*20-10;
        Rabbit baby = new Rabbit(babyX,babyY);
        energy = energy-40;
        reproductionCooldown = 1;
        return baby;
    }

    public boolean canReproduce(){
        return energy>=80&&reproductionCooldown<=0;
    }

    public void updateGraphic(){
        graphic.setCenterX(x);
        graphic.setCenterY(y);
    }
    public Circle getGraphic(){
        return graphic;
    }
}
