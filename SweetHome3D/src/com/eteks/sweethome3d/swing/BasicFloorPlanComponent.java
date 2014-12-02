package com.eteks.sweethome3d.swing;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.undo.UndoableEditSupport;

import com.eteks.sweethome3d.model.*;
import com.eteks.sweethome3d.viewcontroller.*;
import org.freehep.*;
import org.freehep.util.export.ExportDialog;

public class BasicFloorPlanComponent {
  List<Selectable> basicItems;
  List<Wall> wallItems;
  List<Room> roomItems;
  List<HomeDoorOrWindow> doorWindowItems;
  List<HomePieceOfFurniture> furnitureItems;
  Home home;
  UserPreferences preferences;
  BasicFloorPlanController controller; 
  BasicFloorPlanPanel panel;
  JFrame frameMan;
  int width;
  int height;
  
  public BasicFloorPlanComponent(Home home, UserPreferences preferences,
                                BasicFloorPlanController controller){
    this.home = home;
    this.preferences = preferences;
    this.controller = controller;
    
    basicItems = new ArrayList<Selectable>();
    wallItems = new ArrayList<Wall>();
    roomItems = new ArrayList<Room>();
    doorWindowItems = new ArrayList<HomeDoorOrWindow>();
    furnitureItems = new ArrayList<HomePieceOfFurniture>();
    
    frameMan = new JFrame("Basic Floor Plan");

  }
  
  public List<Selectable> getBasicList(){
    return basicItems;
  }
  
  public List<Wall> getWallList(){
    return wallItems;
  }
  
  public List<Room> getRoomList(){
    return roomItems;
  }
  
  public List<HomeDoorOrWindow> getDoorWindowList(){
    return doorWindowItems;
  }
  
  public List<HomePieceOfFurniture> getFurnitureList(){
    return furnitureItems;
  }
  
  public void drawBasicFloorPlan(){
   basicItems = controller.getBasicItems();
   for(Selectable item : basicItems){
     if(item instanceof Room ){
       roomItems.add((Room) item);
     }
     
     else if(item instanceof Wall){
       wallItems.add((Wall) item);
     }
     
     else if(item instanceof HomeDoorOrWindow){
       doorWindowItems.add((HomeDoorOrWindow) item);
     }
     
     else if(item instanceof HomePieceOfFurniture){
       furnitureItems.add((HomePieceOfFurniture) item);
     }
   }
   
   panel = new BasicFloorPlanPanel();
   frameMan.setVisible(true);
   frameMan.setLayout(new BorderLayout());

   frameMan.getContentPane().add(panel, BorderLayout.CENTER);

   width = (panel.getXMax() - panel.getXMin());
   height = (panel.getYMax() - panel.getYMin());
   

   System.out.println(width);
   System.out.println(height);
   
   
   frameMan.setSize(width + (width/2), height+(width/2));
  }
  
  public void exportFloorPlan(){
    ExportDialog exportGuy = new ExportDialog();
    exportGuy.showExportDialog(frameMan, "Save File", panel, "Basic Floor Plan");
  }
  }

