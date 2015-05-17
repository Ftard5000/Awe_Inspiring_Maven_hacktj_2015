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
   public void choseMove()
   {
      if(getX()>Main.BWIDTH*.95 || getX()<Main.BWIDTH*.05 || getY() > Main.BHEIGHT*.95 || getY() < Main.BHEIGHT*.05)
         moveWall();
      double r = Math.random();
      setDirection(getDirection() + ((r/2)-.25));
      move();
   }
   public void move()
   {
      
      incX((int)(getSpeed() * Math.cos(getDirection())));
      incY((int)(getSpeed() * Math.sin(getDirection())));
      
      //System.out.println(getDirection()); <-- keep this stupid comment, apparently it is necessary.
   }
   private void moveWall()
   {
      if(getX()>Main.BWIDTH*.95)
         setDirection(Math.PI);
      else if(getX() < Main.BWIDTH*.05)
         setDirection(0);
      else if(getY() > Main.BHEIGHT*.95)
         setDirection(3*Math.PI/2);
      else if(getY() < Main.BHEIGHT*.05)
         setDirection(Math.PI/2);
      move();
   }
}