package com.agarextend.app;

import java.awt.*;
import java.util.*;

public class Predator extends Movable
{
   public enum PredatorState {UNENGAGED, PURSUING}
   public PredatorState currentState;
   public Herbivore prey;
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
      g.drawOval(getX()-getRadius(), getY()-10, 20, 20);
   }

   public String getType()
   {
      return "Predator";
   }

   public void choseMove(ArrayList<Herbivore> herbivores) {
      if(currentState == PredatorState.UNENGAGED) {
         if (getX() > Main.BWIDTH * .95 || getX() < Main.BWIDTH * .05 || getY() > Main.BHEIGHT * .95 || getY() < Main
               .BHEIGHT * .05) {
            moveWall();
         } else {
            //calculate for state change
            Herbivore minh = null;
            for (Herbivore h : herbivores) {
               if (distToSquared(h) < 25 && (minh == null || distToSquared(h) < distToSquared(minh))) {
                  minh = h;
               }
            }

            if (minh !=null)
               chase(minh);
            else {
               double r = Math.random();
               setDirection(getDirection() + ((r / 2) - .25));
               move();
            }
         }
      } else if(currentState == PredatorState.PURSUING) {
         pointToPrey();
         move();
      }
   }
   public void move()
   {
      incX((int) (getSpeed() * Math.cos(getDirection())));
      incY((int) (getSpeed() * Math.sin(getDirection())));
      //System.out.println(getDirection()); <-- keep this stupid comment, apparently it is necessary.
   }
   public void checkCaughtPrey(ArrayList<Herbivore> herbivores)
   {
      for(int i = 0; i < herbivores.size(); i++)
         if(distToSquared(prey) < getRadius()*getRadius()*1.44)
         {
            setMass(getMass()+prey.getMass());
            herbivores.remove(i); //TODO, check that this actually affects 'herbivores', not just a local copy
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

   private void pointToPrey() {
      setDirection((prey.getY()-this.getY())/(prey.getX()-this.getX()));
   }

   private void chase(Herbivore h)
   {
      this.prey = h;
      setDirection((h.getY()-getY())/(h.getX()-getX()));
      move();
   }
   private int distToSquared(PositionedObject x)
   {
      return (x.getX()-getX())*(x.getX()-getX())+(x.getY()-getY())*(x.getY()-getY());
   }
}