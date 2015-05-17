package com.agarextend.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class GameTimerListener implements ActionListener {
   private GamePanel panel;
   public GameTimerListener(GamePanel panel) {
      this.panel = panel;
   }

   public void actionPerformed(ActionEvent e) {
      panel.getBuffer().setColor(Color.white);
      panel.getBuffer().fillRect(0, 0, panel.getWidth(), panel.getHeight());
      if (panel.getMousePoint() != null) {
         Point playerLocation = panel.getPlayerLocation();
         Point mousePoint = panel.getMousePoint();
         double xdif = playerLocation.getX() - mousePoint.getX();
         double ydif = playerLocation.getY() - mousePoint.getY();
         double angle = Math.atan2(ydif, xdif) * 180 / Math.PI;

         double dX = Math.cos(angle * Math.PI / 180) * 4;
         double dY = Math.sin(angle * Math.PI / 180) * 4;

         for(Predator i : panel.getPredators()) {
            i.display(panel.getBuffer());
         }
         for(Herbivore i : panel.getHerbivores()) {
            i.display(panel.getBuffer());
         }


         // the if test looks confusing but basically it is checking if the sign changes
         /// when adding in dX or dY. if so then set it to the mouseX or mouseY
         double newX = ((playerLocation.getX() - mousePoint.getX()) * (playerLocation.getX() - dX - mousePoint.getX()) > 0)
               ? playerLocation.getX() - dX : mousePoint.getX();
         double newY = ((playerLocation.getY() - mousePoint.getY()) * (playerLocation.getY() - dY - mousePoint.getY()) > 0)
               ? playerLocation.getY() - dY : mousePoint.getY();
                                /*double newX = playerLocation.getX()-dX;
                                double newY = playerLocation.getY()-dY;*/
         playerLocation.setLocation(newX, newY);
         panel.getBuffer().setColor(Color.black);
         panel.getBuffer().fillRect(playerLocation.x-10, playerLocation.y-10, 20, 20);
         panel.repaint();
      }
   }
}
