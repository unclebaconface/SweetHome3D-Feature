package com.eteks.sweethome3d.swing;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.*;
import com.eteks.sweethome3d.model.*;

import javax.swing.JPanel;
//class responsible for drawing the basic floor plan
public class BasicFloorPlanPanel extends JPanel {
  BasicFloorPlanComponent component;
  List<Selectable> basicItems;
  List<Wall> wallItems;
  List<Room> roomItems;
  List<HomeDoorOrWindow> doorWindowItems;
  List<HomePieceOfFurniture> furnitureItems;
  List<int[]> xPointLists;
  List<int[]> yPointLists;
 
  
  public BasicFloorPlanPanel(){
    super();
    
    component = HomePane.getBasicComponent();
    basicItems = new ArrayList<Selectable>();
    wallItems = new ArrayList<Wall>();
    roomItems = new ArrayList<Room>();
    doorWindowItems = new ArrayList<HomeDoorOrWindow>();
    furnitureItems = new ArrayList<HomePieceOfFurniture>();
    xPointLists = new ArrayList<int[]>();
    yPointLists = new ArrayList<int[]>();
    
    //get items from component
    basicItems = component.getBasicList();
    wallItems = component.getWallList();
    roomItems = component.getRoomList();
    doorWindowItems = component.getDoorWindowList();
    furnitureItems = component.getFurnitureList();
    
  }
  /*
  public void getMaxPoints(){
    //from all the items to be drawn, find the largest and smallest
    //points on the plane
    //used to set an appropriate frame size, so that it displays the entire home
    for(Selectable item : basicItems){
      float [][] itemPoints = item.getPoints();
      int[] xPoints = new int[itemPoints.length];
      int[] yPoints = new int[itemPoints.length];
      
      
      for(int i=0;i<itemPoints.length;i++){
        int xMax = 0;
        int yMax = 0;
        int yMin = Integer.MAX_VALUE;
        int xMin = Integer.MAX_VALUE;
        xPoints[i] = (int) itemPoints[i][0];
        //go through all x coordinates of items, find max
        if(xPoints[i] > xMax){
          xMax = xPoints[i];
        }
        //go through all x coordinates of items, find min
        if(xPoints[i] < xMin){
          xMin = xPoints[i];
        }
      }
      
      for(int i=0; i < itemPoints.length;i++){
        int xMax = 0;
        int yMax = 0;
        int yMin = Integer.MAX_VALUE;
        int xMin = Integer.MAX_VALUE;
        yPoints[i] = (int) itemPoints[i][1];
        //go through all y coordinates of items, find max
        if(yPoints[i] > yMax){
          yMax = yPoints[i];
        }
        //go through all y coordinates of items, find min
        if(yPoints[i] < yMin){
          yMin = yPoints[i];
        }
      }
    }
    
  }*/

  public void paintComponent(Graphics g){
    //draw floor plan    
    Graphics2D g2 = (Graphics2D) g;
    for(Wall item : wallItems){
      g2.setStroke(new BasicStroke(5));
      g2.draw(new Line2D.Float(item.getXStart(), item.getYStart(), item.getXEnd(), item.getYEnd()));
    }
    
    for(Room item : roomItems){
      float [][] itemPoints = item.getPoints();
      int [] xPoints = new int[itemPoints.length];
      int [] yPoints = new int[itemPoints.length];
      
      
      for(int i=0; i<itemPoints.length;i++){
        xPoints[i] = (int) itemPoints[i][0];
      }
      
      for(int i=0; i < itemPoints.length;i++){
        yPoints[i] = (int) itemPoints[i][1];
        
      }
      g2.setStroke(new BasicStroke(5));
      g2.drawPolygon(xPoints, yPoints, itemPoints.length);
      
      }
    for(HomeDoorOrWindow item : doorWindowItems){
      int xMax = 0;
      int yMax = 0;
      int yMin = Integer.MAX_VALUE;
      int xMin = Integer.MAX_VALUE;
      float [][] itemPoints = item.getPoints();
      int [] xPoints = new int[itemPoints.length];
      int [] yPoints = new int[itemPoints.length];
      
      
      for(int i=0; i<itemPoints.length;i++){
        xPoints[i] = (int) itemPoints[i][0];
        if(xPoints[i] > xMax){
          xMax = xPoints[i];
        }
        if(xPoints[i] < xMin){
          xMin = xPoints[i];
        }
      }
      
      for(int i=0; i < itemPoints.length;i++){
        yPoints[i] = (int) itemPoints[i][1];
        if(yPoints[i] > yMax){
          yMax = yPoints[i];
        }
        if(yPoints[i] < yMin){
          yMin = yPoints[i];
        }
      }
      g2.setStroke(new BasicStroke(2));

      g2.drawPolygon(xPoints, yPoints, itemPoints.length);
      g2.drawString(item.getName(), (xMin), (yMin));
      
    }
    
    for(HomePieceOfFurniture item : furnitureItems){
      int xMax = 0;
      int yMax = 0;
      int yMin = Integer.MAX_VALUE;
      int xMin = Integer.MAX_VALUE;
      float [][] itemPoints = item.getPoints();
      int [] xPoints = new int[itemPoints.length];
      int [] yPoints = new int[itemPoints.length];
      
      
      for(int i=0; i<itemPoints.length;i++){
        xPoints[i] = (int) itemPoints[i][0];
        if(xPoints[i] > xMax){
          xMax = xPoints[i];
        }
        if(xPoints[i] < xMin){
          xMin = xPoints[i];
        }
      }
      
      for(int i=0; i < itemPoints.length;i++){
        yPoints[i] = (int) itemPoints[i][1];
        if(yPoints[i] > yMax){
          yMax = yPoints[i];
        }
        if(yPoints[i] < yMin){
          yMin = yPoints[i];
        }
      }
      g2.setStroke(new BasicStroke(2));

      g2.drawPolygon(xPoints, yPoints, itemPoints.length);
      g2.drawString(item.getName(), (xMin), yMin);

      
    }
     }
  
  }

      
     
   
  


