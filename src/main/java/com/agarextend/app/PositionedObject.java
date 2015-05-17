package com.agarextend.app;


import java.awt.*;

/* 
   I added sides, mass, xcorners, and ycorners to help me draw 
*/



public abstract class PositionedObject {
   private double x;
   private double y;
   private int sides; //number of sides
   private int mass; //mass of object

//barely (or never) used
   public PositionedObject() {
      this.x = 0;
      this.y = 0;
      this.sides = 0;
      this.mass = 0;
   }
//default
   public PositionedObject(double x, double y) {
      this.x = x;
      this.y = y;
      this.sides = 3;
      this.mass = 1;
   }
   
//barely used   
   public PositionedObject(double x, double y, int sides, int mass) {
      this.x = x;
      this.y = y;
      this.sides = sides;
      this.mass = mass;
   }
   
/**********************************************
   Returns number of sides on object
**********************************************/   
   public int getSides() {
      return sides;
   }
   
/**********************************************
   Increments number of sides on object by i
**********************************************/   
   public void incSides(int i) {
      sides += i;
   }
   
/**********************************************
   Sets the number of sides
**********************************************/
   public void setSize(int i) {
      this.sides = i;
   }

/**********************************************
   Returns mass of object
**********************************************/   
   public int getMass() {
      return mass;
   }
   
/**********************************************
   Increments massof object by i
**********************************************/   
   public void incMass(int i) {
      mass += i;
   }
   
/**********************************************
   Sets the mass
**********************************************/
   public void setMass(int i) {
      this.mass = i;
   }                  

/**********************************************
   Returns x coordinate of object
**********************************************/
   public double getX() {
      return x;
   }

/**********************************************
   Increments x coordinate of object by i
**********************************************/
   public void incX(double i) {
      x += i;
   }
   
/**********************************************
   Sets the value of x
**********************************************/
   public void setX(double x) {
      this.x = x;
   }

/**********************************************
   Returns y coordinate of object
**********************************************/
   public double getY() {
      return y;
   }

/**********************************************
   Sets the value of y
**********************************************/
   public void setY(double y) {
      this.y = y;
   }
   
/**********************************************
   Increments y coordinate of object by i
**********************************************/
   public void incY(double i) {
      y += i;
   }

   public abstract void move();
   public abstract void display();
}
