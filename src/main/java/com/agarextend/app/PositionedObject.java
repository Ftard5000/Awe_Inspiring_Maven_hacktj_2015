package com.agarextend.app;


import java.awt.*;

/* 
   I added sides, mass, xcorners, and ycorners to help me draw 
*/



public abstract class PositionedObject {
   private int x;
   private int y;
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
   Returns x coordinate of object
**********************************************/
   public int getX() {
      return x;
   }

/**********************************************
   Increments x coordinate of object by i
**********************************************/
   public void incX(int i) {
      x += i;
   }
   
/**********************************************
   Sets the value of x
**********************************************/
   public void setX(int x) {
      this.x = x;
   }

/**********************************************
   Returns y coordinate of object
**********************************************/
   public int getY() {
      return y;
   }

/**********************************************
   Sets the value of y
**********************************************/
   public void setY(int y) {
      this.y = y;
   }
   
/**********************************************
   Increments y coordinate of object by i
**********************************************/
   public void incY(int i) {
      y += i;
   }

   public abstract void move();
   public abstract void display();
}
