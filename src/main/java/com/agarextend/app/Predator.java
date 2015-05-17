package com.agarextend.app;

import java.awt.*;

public class Predator extends Movable
{
   public Predator() {
      super();
   }
   
   public Predator(int xC, int yC, int dir, double dist, int m, double s)
   {
      setX(xC);
      setY(yC);
      setDirection(dir);
      setPointerDist(dist);
      setMass(m);
      setSpeed(s);
   }

   public void display(Graphics g) {
      g.setColor(Color.red);
      g.drawOval(getX()-10, getY()-10, 20, 20);
   }

   public String getType()
   {
      return "Predator";
   }
}   