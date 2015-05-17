package com.agarextend.app;

import javax.swing.*;

public class App
{
   private static final int SIZE = 1000;
    public static void main( String[] args )
    {
       JFrame frame = new JFrame("Agar IMproved");
       frame.setSize(SIZE, SIZE);
       GamePanel mainPanel = new GamePanel(SIZE);
       mainPanel.addMouseMotionListener(mainPanel);
       //this.setContentPane(mainPanel);
       frame.add(mainPanel);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frame.setVisible(true);
    }
}
