package com.agarextend.app;

import java.awt.*;
import java.util.*;

public class Predator extends Movable
{
   public enum PredatorState {UNENGAGED, PURSUING}
   public PredatorState currentState;
   public Herbivore prey;
   public Predator() {
      super();
      setSpeed(10.0);
      currentState = PredatorState.UNENGAGED;
   }
   
   public Predator(int xC, int yC, int dir, double dist, int m, double s)
   {
      setX(xC);
      setY(yC);
      setDirection(dir);
      setPointerDist(dist);
      setMass(m);
      setSpeed(s);
      currentState = PredatorState.UNENGAGED;
   }

   public void display(Graphics g, Image img, int x, int y, int rx, int ry) {
      g.drawImage(img, x, y, rx, ry, null);
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
               if (distToSquared(h) < 30*30 && (minh == null || distToSquared(h) < distToSquared(minh))) {
                  minh = h;
               }
            }

            if (minh != null)
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
   public void checkCaughtPrey(ArrayList<Herbivore> herbivores)
   {
      if(prey != null && distToSquared(prey) < getRadius()*getRadius()*1.44)
      {
         setMass(getMass()+prey.getMass());
         herbivores.remove(prey); //TODO, check that this actually affects 'herbivores', not just a local copy
         prey = null;
      }
   }

   private void pointToPrey() {
      if(prey.getX() != this.getX())
         setDirection(Math.atan((prey.getY()-this.getY())/(prey.getX()-this.getX())));
   }

   private void chase(Herbivore h)
   {
      this.prey = h;
      pointToPrey();
      move();
   }
}