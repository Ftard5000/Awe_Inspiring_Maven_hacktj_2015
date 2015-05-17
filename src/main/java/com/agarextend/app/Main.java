package com.agarextend.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Scanner;
 
 
public class Main extends JPanel  implements MouseMotionListener, Runnable {
   public Point mousePoint;
   public Point playerLocation;
   public JFrame winMain;
   public Point aiLocation;
   public ArrayList<Movable> movables;       
   public Main() {
      playerLocation = new Point(100, 100);
      System.out.println("How many by ai's?");
      Scanner sc = new Scanner(System.in);
      int numAis = sc.nextInt();
      movables = new ArrayList<Movable>();
      for(int i = 0; i < numAis; i++)
      {
         double random = Math.random();
         if(random < .66)
            movables.add(new Herbivore());//change to Herbivore
         else
            movables.add(new Predator());
      }
      mousePoint = new Point(100, 100);
               
      winMain = new JFrame();
      winMain.setSize(2000, 2000);
      addMouseMotionListener(this);
      winMain.add(this);
      winMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      winMain.setVisible(true);
      Thread thread = new Thread(this);
      thread.start();
   }
   public static void main(String args[])
   {
      new Main();
         
         
   }
   
   @Override
    public void paint(Graphics g) {
    
      g.clearRect(0, 0, getWidth(), getHeight());
      for(Movable k : movables)
      {
         if (k.getType().equals("Herbivore"))
         {
            g.setColor(Color.blue);
            g.drawOval(k.getX()-10, k.getY()-10, 20, 20);
         }
         else
         {
            g.setColor(Color.red);
            g.drawOval(k.getX()-10, k.getY()-10, 20, 20);
         }   
      }
      g.setColor(Color.black);
      g.fillRect(playerLocation.x-10, playerLocation.y-10, 20, 20);
     
        
   }
   
   
   public void mouseDragged(MouseEvent e) {
   }
   public void mouseMoved(MouseEvent e) {
      mousePoint = e.getPoint();
   }
   public void run() {
      while(winMain.isVisible()) {
                
                
         if(mousePoint != null) {
                                
            double Xdif = playerLocation.getX() - mousePoint.getX();
            double Ydif = playerLocation.getY() - mousePoint.getY();
            double angle = Math.atan2(Ydif, Xdif) * 180 / Math.PI;
         
            double dX = Math.cos(angle * Math.PI/180) * 4;
            double dY = Math.sin(angle * Math.PI/180) * 4;
                                // the if test looks confusing but basically it is checking if the sign changes
                                /// when adding in dX or dY. if so then set it to the mouseX or mouseY
            double newX = ((playerLocation.getX()-mousePoint.getX())*(playerLocation.getX()-dX-mousePoint.getX()) > 0)
                                                ? playerLocation.getX()-dX : mousePoint.getX();
            double newY = ((playerLocation.getY()-mousePoint.getY())*(playerLocation.getY()-dY-mousePoint.getY()) > 0)
                                                ? playerLocation.getY()-dY : mousePoint.getY();
                                /*double newX = playerLocation.getX()-dX;
                                double newY = playerLocation.getY()-dY;*/
            playerLocation.setLocation(newX, newY);
            repaint();
            try {
               Thread.sleep(10);
            } 
            catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
   }
}
