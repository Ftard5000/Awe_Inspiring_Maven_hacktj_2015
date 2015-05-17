package com.agarextend.app;

import javax.swing.*;

public class GameFrame extends JFrame {
   public GameFrame() {
      super();
      GamePane mainPane = new GamePane();
      this.setSize(2000, 2000);
      this.addMouseMotionListener(new GameMouseListener(mainPane));
      this.add(mainPane);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
}
