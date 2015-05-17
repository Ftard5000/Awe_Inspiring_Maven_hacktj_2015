package com.agarextend.app;
public class Herbivore extends Movable
{
   public Herbivore() {
      super();
   }
   
   public Herbivore(int xC, int yC, int dir, double dist, int m, double s)
   {
      setX(xC);
      setY(yC);
      setDirection(dir);
      setPointerDist(dist);
      setMass(m);
      setSpeed(s);
   }

   public void display() {

   }
   
   private String getType()
   {
      return "Herbivore";
   }
     
}   