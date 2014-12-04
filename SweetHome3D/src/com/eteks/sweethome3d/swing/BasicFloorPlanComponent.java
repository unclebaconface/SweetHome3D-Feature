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


//Responsible for gathering basic items that need to be drawn
//and sending them to the panel class
//also responsible for creating and displaying the basic floor
//plan frame
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
  JScrollPane scrollMan;
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
    
  }
  
  //getters to provide access to panel class
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
  
  //Separate items into lists to be used by panel class
  public void drawBasicFloorPlan(){
   basicItems = controller.getBasicItems();
   //four classes that basic items can belong to: rooms,
   //walls, doors and windows, furniture (plumbing- sinks, toilets, etc)
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
   panel.setPreferredSize(new Dimension(750,750));
   scrollMan = new JScrollPane(panel);
   scrollMan.setViewportView(panel);
   

   //create new frame on top of existing one
   frameMan = new JFrame("Basic Floor Plan");

   frameMan.setSize(450,450);
   //frameMan.setLayout(new BorderLayout());

   //frameMan.getContentPane().add(panel, BorderLayout.CENTER);
   frameMan.add(scrollMan);
   frameMan.setVisible(true);

   //get width and height from panel to set size of frame
 //  width = (panel.getXMax() - panel.getXMin());
 //  height = (panel.getYMax() - panel.getYMin());
   
   //set size of frame to be slightly bigger than max width and height
   //frameMan.setSize(width + (width/2), height+(width/2));
   
  }
  
  //open export dialog, responsible for saving floor plan to one of
  //many possible file formats
  public void exportFloorPlan(){
    ExportDialog exportGuy = new ExportDialog();
    exportGuy.showExportDialog(frameMan, "Save File", panel, "Basic Floor Plan");
  }
  }

