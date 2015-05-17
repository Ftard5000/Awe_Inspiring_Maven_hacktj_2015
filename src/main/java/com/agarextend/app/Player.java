package com.agarextend.app;

import javax.swing.*;
import java.awt.*;
public class Player extends PositionedObject
{  
   private double speed;
   private final double pi = Math.PI;
   public Player(){
      super(0, 0);
      speed = 1;
   }
   public void move(){
      
   }
   public int getRadius() {return 0;}
}