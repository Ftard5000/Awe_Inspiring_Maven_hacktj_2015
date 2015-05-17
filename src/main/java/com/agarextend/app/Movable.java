package com.agarextend.app;
public abstract class Movable extends PositionedObject
{
   private double direction;
   private double pointerDist;
   private double mass;
   private double speed;
   private final double pi = Math.PI;

   public Movable()
   {
      super(Math.random(), Math.random());
      direction = 0;
      pointerDist = 0.0;
      mass = 10.0;
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


   private double getMass()
   {
      return mass;
   }

   public void setMass(double m) {
      this.mass = m;
   }

   public double getPi() {
      return pi;
   }

   public void addMass()
   {
      mass++;
      speed = 1/mass;
   }
   
   public void addMass(Movable m)
   {
      mass += m.getMass();
      speed = 1/mass;
   }

   public void move()
   {
      incX(speed * Math.cos(direction));
      incY(speed * Math.sin(direction));
   }
}