package com.agarextend.app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GameMouse implements MouseMotionListener {
   private GamePanel panel;
   public GameMouse(GamePanel panel) {
      this.panel = panel;
   }

   public void mouseDragged(MouseEvent e) {}
   public void mouseMoved(MouseEvent e) {
      
   }
}
