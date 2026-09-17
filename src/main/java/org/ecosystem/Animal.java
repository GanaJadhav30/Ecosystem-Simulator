package org.ecosystem;

public abstract class Animal {
    protected double x;
    protected double y;
    protected double energy;
    protected double age;
    public Animal(double x,double y){
        this.x = x;
        this.y = y;
        this.energy=100;
        this.age = 0;
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
    public double getAge(){return age;}
    public abstract void move();
    public boolean isDead(){
        return energy<=0 || age >=60;
    }
}
