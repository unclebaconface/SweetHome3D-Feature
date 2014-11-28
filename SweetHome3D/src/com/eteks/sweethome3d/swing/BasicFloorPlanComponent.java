package com.eteks.sweethome3d.swing;
import java.awt.Dimension;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import com.eteks.sweethome3d.model.*;
import com.eteks.sweethome3d.viewcontroller.*;

import org.freehep.graphicsio.ImageConstants;
import org.freehep.graphicsio.svg.SVGGraphics2D;
import org.freehep.util.UserProperties;

import java.io.*;

public class BasicFloorPlanComponent extends PlanComponent {
  Home home;
  UserPreferences preferences;
  PlanController controller;
  List<Selectable> basicHomeItems;
  List<Selectable> allItems;
  PlanComponent component;
  Rectangle2D itemBounds;
  Dimension imageSize;
  Float imageScale;
  SVGGraphics2D export;
  OutputStream output;
  

  public BasicFloorPlanComponent(Home home, UserPreferences preferences, 
                                 BasicFloorPlanController controller){
    super(home, preferences, controller);
    this.home = home;
    this.preferences = preferences;
    this.controller = controller;
    this.allItems = new ArrayList<Selectable>();
    this.basicHomeItems = new ArrayList<Selectable>();
    
  }
  
  public void exportToSVG() throws InterruptedIOException{
   allItems = component.getPaintedItems();
   
   basicHomeItems = controller.getItemsPartOfBasePlan(allItems);
   
   itemBounds = component.getItemsBounds(null, basicHomeItems);
   imageScale = 1f;
   
   imageSize = new Dimension((int)Math.ceil(itemBounds.getWidth() * imageScale), 
       (int)Math.ceil(itemBounds.getHeight() * imageScale));
   
   export = new SVGGraphics2D(output, imageSize);
   export.startExport();
   component.paintContent(export, imageScale, PaintMode.EXPORT);
   export.endExport();
  
  }
}
