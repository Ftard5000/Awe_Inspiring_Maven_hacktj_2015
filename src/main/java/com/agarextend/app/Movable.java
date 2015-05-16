package com.agarextend.app;
public class Movable extends PositionedObject
{
   private double direction;
   private double pointerDist;
   private int mass;
   private double speed;
   private final double pi = Math.PI;
   private final String display = new String("_");
   
   public Movable()
   {
      super(Math.random(), Math.random());
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
   
   private void addMass(Movable m)
   {
      mass += m.getMass();
      speed = 1/mass;
   }
   
   private int getMass()
   {
      return mass;
   }
   private int setMass(int m) { this.mass = m; }

   private void move()
   {
      incX(speed * Math.cos(direction));
      incY(speed * Math.sin(direction));
   }
   
   private String getChar()
   {
      return display;
   }
   
}