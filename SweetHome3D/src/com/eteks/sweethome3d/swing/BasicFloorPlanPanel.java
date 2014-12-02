package com.eteks.sweethome3d.swing;
import java.awt.*;
import java.util.List;
import java.util.*;
import com.eteks.sweethome3d.model.*;

import javax.swing.JPanel;

public class BasicFloorPlanPanel extends JPanel {
  BasicFloorPlanComponent component;
  List<Selectable> basicItems;
  List<Wall> wallItems;
  List<Room> roomItems;
  List<HomeDoorOrWindow> doorWindowItems;
  List<HomePieceOfFurniture> furnitureItems;
  List<int[]> xPointLists;
  List<int[]> yPointLists;
  int xMax = 0;
  int yMax = 0;
  int yMin = Integer.MAX_VALUE;
  int xMin = Integer.MAX_VALUE;
  
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
    
    basicItems = component.getBasicList();
    wallItems = component.getWallList();
    roomItems = component.getRoomList();
    doorWindowItems = component.getDoorWindowList();
    furnitureItems = component.getFurnitureList();
    
    getMaxPoints();
  }
  
  public void getMaxPoints(){
    for(Selectable item : basicItems){
      float [][] itemPoints = item.getPoints();
      int[] xPoints = new int[itemPoints.length];
      int[] yPoints = new int[itemPoints.length];
      
      
      for(int i=0;i<itemPoints.length;i++){
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
    }
    
  }
  
  public int getXMax(){
    return xMax;
  }
  
  public int getXMin(){
    return xMin;
  }
  
  public int getYMax(){
    return yMax;
  }
  public int getYMin(){
    return yMin;
  }
  public void paintComponent(Graphics g){
    for(Wall item : wallItems){
      g.drawLine((int) item.getXStart(), (int) item.getYStart(), (int) item.getXEnd(), (int) item.getYEnd());
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
      
      g.drawPolygon(xPoints, yPoints, itemPoints.length);
      
      }
    for(HomeDoorOrWindow item : doorWindowItems){
      float [][] itemPoints = item.getPoints();
      int [] xPoints = new int[itemPoints.length];
      int [] yPoints = new int[itemPoints.length];
      
      
      for(int i=0; i<itemPoints.length;i++){
        xPoints[i] = (int) itemPoints[i][0];
      }
      
      for(int i=0; i < itemPoints.length;i++){
        yPoints[i] = (int) itemPoints[i][1];
      }
      
      g.drawPolygon(xPoints, yPoints, itemPoints.length);
      
    }
    
    for(HomePieceOfFurniture item : furnitureItems){
      float [][] itemPoints = item.getPoints();
      int [] xPoints = new int[itemPoints.length];
      int [] yPoints = new int[itemPoints.length];
      
      
      for(int i=0; i<itemPoints.length;i++){
        xPoints[i] = (int) itemPoints[i][0];
      }
      
      for(int i=0; i < itemPoints.length;i++){
        yPoints[i] = (int) itemPoints[i][1];
      }
      
      g.drawPolygon(xPoints, yPoints, itemPoints.length);
      
    }
     }
  
  }

      
     
   
  


