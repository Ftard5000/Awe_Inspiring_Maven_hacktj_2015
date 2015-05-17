package com.agarextend.app;
public abstract class Movable extends PositionedObject
{
   private double direction;
   private double pointerDist;
   private double speed;
   private static final double pi = Math.PI;
   private static final int RADIUSCONSTANT = 2;

   public Movable()
   {
      super((int)(Math.random()*Main.BWIDTH), (int)(Math.random()*Main.BHEIGHT));
      direction = 0;
      pointerDist = 0.0;
      setMass(10);
      speed = 3.0;
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

   public int getRadius() {
      return getMass()/RADIUSCONSTANT;
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