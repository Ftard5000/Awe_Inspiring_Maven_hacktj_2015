package com.agarextend.app;

public abstract class PositionedObject {
   private double x;
   private double y;

   public PositionedObject() {
      this.x = 0;
      this.y = 0;
   }

   public PositionedObject(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public double getX() {
      return x;
   }

   public void incX(double i) {
      x += i;
   }
   public void setX(double x) {
      this.x = x;
   }

   public double getY() {
      return y;
   }

   public void setY(double y) {
      this.y = y;
   }

   public void incY(double i) {
      y += i;
   }

   public abstract void move();
   public abstract void display();
}
