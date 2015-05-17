package com.agarextend.app;
import java.util.*;

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
   public void checkCollide(ArrayList<Pellet> pellets)
   {
      for(int i = 0; i < pellets.size(); i++)
         if(distTo(pellets.get(i)) < (getMass()/2)*(getMass()/2))//CHANGE THIS TO RADIUSCONSTANT
         {
            setMass(getMass()+pellets.get(i).getMass());
            pellets.remove(i);
         }
   
   }
   private void moveWall()
   {
      if(getX()>Main.BWIDTH*.95)
         setDirection(Math.PI);
      else if(getX() < Main.BWIDTH*.05)
         setDirection(0);
      else if(getY() > Main.BHEIGHT)
         setDirection(3*Math.PI/2);
      else if(getY() < Main.BHEIGHT*.05)
         setDirection(Math.PI/2);
      move();
   }
   private int distTo(PositionedObject x)
   {
      return (int)((x.getX()-getX())*(x.getX()-getX())+(x.getY()-getY())*(x.getY()-getY()));
   }
}