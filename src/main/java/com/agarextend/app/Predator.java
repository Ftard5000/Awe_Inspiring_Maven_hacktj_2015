package com.agarextend.app;

import java.awt.*;
import java.util.*;

public class Predator extends Movable
{
   public int moveCount = 0;
   public Predator() {
      super();
      setSpeed(10.0);
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
      g.drawOval(getX()-, getY()-10, 20, 20);
   }

   public String getType()
   {
      return "Predator";
   }
   public void choseMove(ArrayList<Herbivore> herbivores)
   {
      if(getX()>Main.BWIDTH*.95 || getX()<Main.BWIDTH*.05 || getY() > Main.BHEIGHT*.95 || getY() < Main.BHEIGHT*.05)
         moveWall();
      else if(moveCount < 5)
      {
         boolean nearSmallPrey;
         for(Herbivore h : herbivores)
            if(distTo(h) < 25)
               chase(h);
         moveCount++;
      }
      else
      {
         moveCount = 0;   
         double r = Math.random();
         setDirection(getDirection() + ((r/2)-.25));
         move();
      }
   }
   public void move()
   {
      
      incX((int)(getSpeed() * Math.cos(getDirection())));
      incY((int)(getSpeed() * Math.sin(getDirection())));
      
      //System.out.println(getDirection()); <-- keep this stupid comment, apparently it is necessary.
   }
   public void checkCollide(ArrayList<Herbivore> herbivores)
   {
      for(int i = 0; i < herbivores.size(); i++)
         if(distTo(herbivores.get(i)) < (getMass()/2)*(getMass()/2) && getMass() >= 1.2*herbivores.get(i).getMass())//CHANGE THIS TO RADIUSCONSTANT
         {
            setMass(getMass()+herbivores.get(i).getMass());
            herbivores.remove(i);
         }
   
   }
   private void moveWall()
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
   
   private void chase(Herbivore h)
   {
      setDirection((h.getY()-getY())/(h.getX()-getX()));
      move();
   }
   private int distTo(PositionedObject x)
   {
      return (int)((x.getX()-getX())*(x.getX()-getX())+(x.getY()-getY())*(x.getY()-getY()));
   }
}