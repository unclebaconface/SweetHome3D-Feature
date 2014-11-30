package com.eteks.sweethome3d.swing;
import java.awt.*;
import java.util.List;
import java.util.*;
import com.eteks.sweethome3d.model.*;

import javax.swing.JPanel;

public class BasicFloorPlanPanel extends JPanel {
  BasicFloorPlanComponent component;
  List<Wall> wallItems;
  List<Room> roomItems;
  List<HomeDoorOrWindow> doorWindowItems;
  List<HomePieceOfFurniture> furnitureItems;
  
  public BasicFloorPlanPanel(){
    super();
    
    component = HomePane.getBasicComponent();
    wallItems = new ArrayList<Wall>();
    roomItems = new ArrayList<Room>();
    doorWindowItems = new ArrayList<HomeDoorOrWindow>();
    furnitureItems = new ArrayList<HomePieceOfFurniture>();
    
    wallItems = component.getWallList();
    roomItems = component.getRoomList();
    doorWindowItems = component.getDoorWindowList();
    furnitureItems = component.getFurnitureList();
    
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

      
     
   
  


