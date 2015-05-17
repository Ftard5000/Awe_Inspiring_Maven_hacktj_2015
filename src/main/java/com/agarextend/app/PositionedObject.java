package com.agarextend.app;


import java.awt.*;

import javax.swing.*;




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
   public PositionedObject(int x, int y) {
      this.x = x;
      this.y = y;
      this.sides = 3;
      this.mass = 1;
   }
   
//barely used   
   public PositionedObject(int x, int y, int sides, int mass) {
      this.x = x;
      this.y = y;
      this.sides = sides;
      this.mass = mass;
   }

   public void setSides(int sides) {
      this.sides = sides;
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
   
/**********************************************
   Recieves name of image file based on the number of sides
**********************************************/
   public String shapeName(){
      return this.getSides() + ".png";
   }
      
   public void display(){
   }
   
      
   public abstract void move();
}
