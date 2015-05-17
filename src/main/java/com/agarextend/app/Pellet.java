package com.agarextend.app;
public class Pellet extends PositionedObject
{
   public Pellet()
   {
      setX((int)(Math.random()*Main.BWIDTH));
      setY((int)(Math.random()*Main.BHEIGHT));
      setSides(10);
      setMass((int)((Math.random()*3) +1.0));
   }
}