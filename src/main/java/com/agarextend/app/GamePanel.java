package com.agarextend.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

public class GamePanel extends JPanel implements MouseMotionListener {
   private Point mousePoint;
   private Point playerLocation;
   private ArrayList<Predator> predators;
   private ArrayList<Herbivore> herbivores;
   private BufferedImage image;
   private Graphics buffer;
   private Timer timer;
   private int frameSize;
   public GamePanel(int size) {
      frameSize = size;

      image = new BufferedImage(frameSize, frameSize, BufferedImage.TYPE_INT_RGB);
      buffer = image.getGraphics();

      playerLocation = new Point(100, 100);
      System.out.println("How many by ai's?");
      Scanner sc = new Scanner(System.in);
      int numAis = sc.nextInt();
      predators = new ArrayList<Predator>();
      herbivores = new ArrayList<Herbivore>();
      for(int i = 0; i < numAis; i++)
      {
         double random = Math.random();
         if(random < .66)
            herbivores.add(new Herbivore());//change to Herbivore
         else
            predators.add(new Predator());
      }
      mousePoint = new Point(100, 100);

      timer = new Timer(10, new GameTimerListener(this));
      timer.start();
   }

   public Point getMousePoint() {
      return mousePoint;
   }

   public void setMousePoint(Point mousePoint) {
      this.mousePoint = mousePoint;
   }

   public Point getPlayerLocation() {
      return playerLocation;
   }

   public void setPlayerLocation(Point playerLocation) {
      this.playerLocation = playerLocation;
   }

   public ArrayList<Predator> getPredators() {
      return predators;
   }

   public void setPredators(ArrayList<Predator> predators) {
      this.predators = predators;
   }

   public ArrayList<Herbivore> getHerbivores() {
      return herbivores;
   }

   public void setHerbivores(ArrayList<Herbivore> herbivores) {
      this.herbivores = herbivores;
   }

   public Graphics getBuffer() {
      return buffer;
   }

   @Override
   public void paintComponent(Graphics g) {
      g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
   }

   public void mouseDragged(MouseEvent e) {}

   public void mouseMoved(MouseEvent e) {
      mousePoint = e.getPoint();
   }
}
