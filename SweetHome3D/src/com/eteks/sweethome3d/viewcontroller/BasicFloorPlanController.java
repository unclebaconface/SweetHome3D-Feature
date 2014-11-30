package com.eteks.sweethome3d.viewcontroller;
import java.util.*;
import java.util.concurrent.Callable;

import javax.swing.undo.UndoableEditSupport;
import com.eteks.sweethome3d.model.*;
import com.eteks.sweethome3d.swing.HomePane;
import com.eteks.sweethome3d.viewcontroller.*;

//MVC controller for BasicFloorPlanView
public class BasicFloorPlanController extends PlanController{
  List<Selectable> allItems;
  List<Selectable> basicItems;
  List<Selectable> nonBasicItems;
  Boolean visibleFalse = false;
  private BasicPlanView basicPlanView;
  private final Home                  home;
  private final UserPreferences       preferences;
  private final ViewFactory           viewFactory;
  private final ContentManager        contentManager;
  private final UndoableEditSupport   undoSupport;
    
  public BasicFloorPlanController(Home home, UserPreferences preferences, 
                                  ViewFactory viewFactory, 
                                  ContentManager contentManager,
                                  UndoableEditSupport undoSupport){
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
    basicItems = getItemsPartOfBasePlan(allItems);
    return basicItems;
  }
}

