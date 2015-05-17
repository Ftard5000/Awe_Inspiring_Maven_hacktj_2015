package com.agarextend.app;
public abstract class Movable extends PositionedObject
{
   private double direction;
   private double pointerDist;
   private double speed;
   private final double pi = Math.PI;

   public Movable()
   {
      super((int)(Math.random()*100), (int)(Math.random()*100));
      direction = 0;
      pointerDist = 0.0;
      setMass(10);
      speed = 1.0;
   }

   public double getDirection() {
      return direction;
   }

   public void setDirection(double direction) {
      this.direction = direction;
   }

   public double getPointerDist() {
      return pointerDist;
   }

   public void setPointerDist(double pointerDist) {
      this.pointerDist = pointerDist;
   }

   public double getSpeed() {
      return speed;
   }

   public void setSpeed(double speed) {
      this.speed = speed;
   }

   public double getPi() {
      return pi;
   }

   public void move()
   {
      incX((int)(speed * Math.cos(direction)));
      incY((int)(speed * Math.sin(direction)));
   }
   public String getType()
   {
      return "Movable";
   }
}