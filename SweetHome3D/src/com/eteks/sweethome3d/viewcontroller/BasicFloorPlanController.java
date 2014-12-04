package com.eteks.sweethome3d.viewcontroller;
import java.util.*;
import java.util.concurrent.Callable;

import javax.swing.undo.UndoableEditSupport;
import com.eteks.sweethome3d.model.*;
import com.eteks.sweethome3d.swing.HomePane;
import com.eteks.sweethome3d.viewcontroller.*;

//Class responsible for gathering of basic items from all items
//Extends features of PlanController by adding the option to only
//export basic floor plan items (walls, windows, doors, plumbing,etc)
public class BasicFloorPlanController extends PlanController{
  List<Selectable> allItems;
  List<Selectable> basicItems;
  List<Selectable> nonBasicItems;
  private final Home                  home;
  private final UserPreferences       preferences;
  private final ViewFactory           viewFactory;
  private final ContentManager        contentManager;
  private final UndoableEditSupport   undoSupport;
    
  public BasicFloorPlanController(Home home, UserPreferences preferences, 
                                  ViewFactory viewFactory, 
                                  ContentManager contentManager,
                                  UndoableEditSupport undoSupport){
    //required call to super class constructor
    super(home, preferences, viewFactory, contentManager, undoSupport);
    this.basicItems = new ArrayList<Selectable>();
    this.nonBasicItems = new ArrayList<Selectable>();
    this.allItems = new ArrayList<Selectable>();
    this.home = home;
    this.preferences = preferences;
    this.viewFactory = viewFactory;
    this.contentManager = contentManager;
    this.undoSupport = undoSupport;
  }
  
  public List<Selectable> getBasicItems(){
    //go through all types of objects in home (furniture, walls, rooms)
    //add to list of total objects
    for(Selectable item : this.home.getFurniture()){
      if(!allItems.contains(item)){
        allItems.add(item);
      }
    }
    
    for(Wall item : this.home.getWalls()){
      if(!allItems.contains(item)){
        allItems.add((Wall)item);
        }    
      }
    
    for(Room item: this.home.getRooms()){
      if(!allItems.contains(item)){
        allItems.add((Room)item);
        }    
      }
    //pass total item list to getItemsPartOfBasePlan method implemented in PlanController
    //store list in basicItems
    basicItems = getItemsPartOfBasePlan(allItems);
    //return basicItems to be accessible by other classes
    return basicItems;
  }
}

