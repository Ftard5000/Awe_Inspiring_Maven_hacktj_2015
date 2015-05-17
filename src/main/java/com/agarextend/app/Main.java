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
   public static final int BHEIGHT = 1000;
   public static final int BWIDTH = 1000;
   public JFrame winMain;
   public Point aiLocation; 
   private ArrayList<Predator> predators;
   private ArrayList<Herbivore> herbivores;
   private ArrayList<Pellet> pellets;      
   public Main() {
      playerLocation = new Point(100, 100);
      System.out.println("How many by ai's?");
      Scanner sc = new Scanner(System.in);
      int numAis = sc.nextInt();
      predators = new ArrayList<Predator>();
      herbivores = new ArrayList<Herbivore>();
      pellets = new ArrayList<Pellet>();
      for(int i = 0; i < numAis; i++)
      {
         double random = Math.random();
         if(random < .66)
            herbivores.add(new Herbivore());
         else
            predators.add(new Predator());
      }
      for(int i = 0; i < numAis*5; i ++)
      {
         pellets.add(new Pellet());
      }
      mousePoint = new Point(100, 100);
               
      winMain = new JFrame();
      winMain.setSize(BHEIGHT, BWIDTH);
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
      g.setColor(Color.red);
      int radius;
      for(Predator k : predators)
      {
         g.fillOval(k.getX()-k.getRadius(), k.getY()-k.getRadius(), k.getRadius()*2, k.getRadius()*2);
      }
      g.setColor(Color.blue);
      for(Herbivore k : herbivores)
      {
         g.fillOval(k.getX()-k.getRadius(), k.getY()-k.getRadius(), k.getRadius()*2, k.getRadius()*2);
      }
      g.setColor(Color.black);
      for(Pellet k : pellets)
      {
         g.fillOval(k.getX()-k.getRadius(), k.getY()-k.getRadius(), 2*k.getRadius(), 2*k.getRadius());
      }
      g.setColor(Color.red);
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
            double newX = ((playerLocation.getX()-mousePoint.getX())*(playerLocation.getX()-dX-mousePoint.getX()) > 0)
                                                ? playerLocation.getX()-dX : mousePoint.getX();
            double newY = ((playerLocation.getY()-mousePoint.getY())*(playerLocation.getY()-dY-mousePoint.getY()) > 0)
                                                ? playerLocation.getY()-dY : mousePoint.getY();
            playerLocation.setLocation(newX, newY);
            for(Herbivore h : herbivores)
               h.choseMove();
            for(Predator p : predators)
               p.choseMove();
            if(Math.random()<.01)
               pellets.add(new Pellet());
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