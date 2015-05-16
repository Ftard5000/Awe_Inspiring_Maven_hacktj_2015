package com.agarextend.app;
public class Predator extends Movable
{
   private int x;
   private int y;
   private double direction;
   private double pointerDist;
   private int mass;
   private double speed;
   private final double pi = Math.PI;
   private final String display = new String("P");
   public Predator()
   {
      x = (int)(Math.random());
      y = (int)(Math.random());
      direction = 0;
      pointerDist = 0.0;
      mass = 10;
      speed = 2.0;
   }
   
   public Predator(int xC, int yC, int dir, double dist, int m, double s)
   {
      x = xC;
      y = yC;
      direction = dir;
      pointerDist = dist;
      mass = m;
      speed = s;
   }
}   