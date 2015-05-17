package com.agarextend.app;

import javax.swing.*;

public class GameFrame extends JFrame {
   private final int SIZE = 1000;
   public GameFrame(String s) {
      super(s);
      GamePanel mainPanel = new GamePanel(SIZE);
      this.setSize(SIZE, SIZE);
      this.addMouseMotionListener(mainPanel);
      //this.setContentPane(mainPanel);
      this.add(mainPanel);
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
}
