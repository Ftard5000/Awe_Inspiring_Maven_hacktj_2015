package com.agarextend.app;
public class Movable
{
   private int x;
   private int y;
   private double direction;
   private double pointerDist;
   private int mass;
   private double speed;
   private final double pi = Math.Pi();
   
   public Movable()
   {
      x = (int)(Math.random());
      y = (int)(Math.random());
      direction = 0;
      pointerDist = 0.0;
      mass = 10;
      speed = 1.0;
   }
   
   private void addMass()
   {
      mass++;
      speed = 1/mass;
   }
   
   private void addMass(Movable x)
   {
      mass += x.getMass();
      speed = 1/mass;
   }
   
   private int getMass()
   {
      return mass;
   }
   
   private void move()
   {
      x += speed * Math.cos(direction);
      y += speed * Math.sin(direction);
   }
   
}