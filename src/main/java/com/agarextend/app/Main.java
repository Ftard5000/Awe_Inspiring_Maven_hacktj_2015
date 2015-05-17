package com.agarextend.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
 
public class Main extends JPanel  implements MouseMotionListener, Runnable {
   private Image background;
   public Point mousePoint;
   public Point playerLocation;
   public static final int BHEIGHT = 750;
   public static final int BWIDTH = 750;
   public JFrame winMain;
   public Point aiLocation; 
   public ArrayList<Predator> predators;
   public ArrayList<Herbivore> herbivores;
   public ArrayList<Pellet> pellets;      
   public Main() {
      playerLocation = new Point(100, 100);
      System.out.println("How many ai's?");
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
      
      
      //set background image
      try{
         background = ImageIO.read(new File ("C:/Sites/Awe_Inspiring_maven_hacktj_2015/src/main/java/com/agarextend/app/background.png"));
      }
      catch (IOException e)
      {
         System.out.println("error loading background");
      }
   
      
               
      winMain = new JFrame();
      winMain.setSize(BHEIGHT, BWIDTH);
      addMouseMotionListener(this);
      winMain.add(this);
      winMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
      g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
      FilePaths paths = new FilePaths();
      
      //g.setColor(Color.red);
      
      for(Predator k : predators)
      {
         try{
            Image img = ImageIO.read(paths.path("pred", k.getSides()));
            k.display(g, img, k.getX()-k.getRadius(), k.getY()-k.getRadius(), 20+2*k.getRadius(), 20+2*k.getRadius());
            //k.display(g, img, k.getX()-k.getRadius(), k.getY()-k.getRadius(), 100, 100);
         }
         catch (IOException e)
         {
            System.out.println(k.getSides() + paths.toString("pred", k.getSides()));
         }
      }
      //g.setColor(Color.blue);
      for(Herbivore k : herbivores)
      {
         try{
            Image img = ImageIO.read(paths.path("herb", k.getSides()));
            k.display(g, img, k.getX()-k.getRadius(), k.getY()-k.getRadius(), 20+2*k.getRadius(), 20+2*k.getRadius());
            //k.display(g, img, k.getX()-k.getRadius(), k.getY()-k.getRadius(), 100, 100);
         }
         catch (IOException e)
         {
            System.out.println(k.getSides() + paths.toString("herb", k.getSides()));
         }
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
            {
               h.choseMove();
               h.checkCollidePellets(pellets);
            }
            for(Predator p : predators)
            {
               p.choseMove(herbivores);
               p.checkCaughtPrey(herbivores);
            }
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