package org.ecosystem;

public abstract class Animal {
    protected double x;
    protected double y;
    protected double energy;

    public Animal(double x,double y){
        this.x = x;
        this.y = y;
    }
    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }
    public double getEnergy(){
        return energy;
    }
    public abstract void move();
}
