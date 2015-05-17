package com.agarextend.app;
import java.util.*;

import java.awt.*;

public class Herbivore extends Movable
{
   public Herbivore() {
      super();
      setSpeed(3.0);
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
      g.drawOval(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());
   }
   
   public String getType()
   {
      return "Herbivore";
   }
   
   public void choseMove()
   {
      if(getX()>Main.BWIDTH*.95 || getX()<Main.BWIDTH*.05 || getY() > Main.BHEIGHT*.95 || getY() < Main.BHEIGHT*.05)
         moveWall();
      double r = Math.random();
      setDirection(getDirection() + ((r/2)-.25));
      move();
   }
}