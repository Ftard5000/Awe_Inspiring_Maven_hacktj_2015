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
   
   public void choseMove()
   {
      if(getX()>950 || getX()<50 || getY() > 950 || getY() < 50)
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
      if(getX()>950)
         setDirection(Math.PI);
      else if(getX() < 50)
         setDirection(0);
      else if(getY() > 950)
         setDirection(3*Math.PI/2);
      else
         setDirection(Math.PI/2);
      move();
   }
}   