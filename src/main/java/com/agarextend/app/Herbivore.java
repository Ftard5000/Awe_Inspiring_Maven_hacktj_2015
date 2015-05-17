package com.agarextend.app;

import java.awt.*;

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

   public void display(Graphics g) {
      g.setColor(Color.blue);
      g.drawOval(getX()-10, getY()-10, 20, 20);
   }
   
   public String getType()
   {
      return "Herbivore";
   }
     
}   