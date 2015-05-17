package com.agarextend.app;

import javax.swing.*;

public class GameFrame extends JFrame {
   public GameFrame(String s) {
      super(s);
      GamePanel mainPanel = new GamePanel();
      this.setSize(500, 500);
      this.addMouseMotionListener(new GameMouse(mainPanel));
      //this.setContentPane(mainPanel);
      this.add(mainPanel);
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
}
