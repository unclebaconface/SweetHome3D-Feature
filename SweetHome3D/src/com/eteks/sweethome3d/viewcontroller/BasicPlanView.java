package com.eteks.sweethome3d.viewcontroller;
import java.util.List.*;
import com.eteks.*;

//View that displays the basic floor plan view
public interface BasicPlanView extends PlanView {
  
  //set the view to only display items part of basic floorplan
  public abstract void setNonBasicItemsInvisible();
  
  //export basic floorplan to SVG format
  public abstract void exportBasicFloorPlanToSVG();
}
