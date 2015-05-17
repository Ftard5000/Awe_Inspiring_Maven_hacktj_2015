package com.agarextend.app;

import java.util.ArrayList;

public abstract class Movable extends PositionedObject
{
   private double direction;
   private double pointerDist;
   private double speed;
   private final double pi = Math.PI;
   public static final int RADIUSCONSTANT = 2;

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

   public void move()
   {
      incX((int) (speed/(Math.sqrt((double)getMass())/5) * Math.cos(direction)));
      incY((int) (speed/(Math.sqrt((double)getMass())/5) * Math.sin(direction)));
   }

   public String getType()
   {
      return "Movable";
   }

   public int getRadius() {
      return getMass()/RADIUSCONSTANT;
   }

   public void checkCollidePellets(ArrayList<Pellet> pellets)
   {
      for(int i = 0; i < pellets.size(); i++)
         if(distToSquared(pellets.get(i)) < getRadius()*getRadius())
         {
            setMass(getMass()+pellets.get(i).getMass());
            pellets.remove(i);
         }

   }

   protected int distToSquared(PositionedObject x)
   {
      return ((x.getX()-getX())*(x.getX()-getX()) + (x.getY()-getY())*(x.getY()-getY()));
   }

   protected void moveWall()
   {
      if(getX() < Main.BWIDTH*.05)
         setDirection(0);
      else if(getX() > Main.BWIDTH*.95)
         setDirection(Math.PI);
      else if(getY() < Main.BHEIGHT * .05)
         setDirection(Math.PI/2);
      else if(getY() > Main.BHEIGHT * .95)
         setDirection(3*Math.PI/2);
      move();
   }
}