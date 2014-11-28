package com.eteks.sweethome3d.viewcontroller;
import java.util.*;
import java.util.concurrent.Callable;

import javax.swing.undo.UndoableEditSupport;
import com.eteks.sweethome3d.model.*;
import com.eteks.sweethome3d.swing.HomePane;
import com.eteks.sweethome3d.viewcontroller.*;

//MVC controller for BasicFloorPlanView
public class BasicFloorPlanController extends PlanController implements Controller {
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
  
  public BasicPlanView getView(){
    if(this.basicPlanView == null){
      this.basicPlanView = this.viewFactory.createBasicFloorPlanView(this.home, this.preferences, this);
    }
    return this.basicPlanView;
  }
  
 

  @SuppressWarnings("unchecked")
  public void setNonBasicItemsInvisible(){
      allItems = this.home.getSelectedItems();
      nonBasicItems = getItemsNotPartOfBasePlan(allItems);
      
      @SuppressWarnings("unchecked")
      List<HomePieceOfFurniture> nonBasicFurnitureItems = (List<HomePieceOfFurniture>)(List<?>) nonBasicItems;
      
      for (HomePieceOfFurniture item : nonBasicFurnitureItems){
        item.setVisible(visibleFalse);
      }
    }
}
  
  /*
  
  public void exportBasicFloorPlanToSVG() {
    final String svgName = getView().showExportToSVGDialog(this.home.getName());    
    if (svgName != null) {
      // Export 3D view in a threaded task
      Callable<Void> exportToSvgTask = new Callable<Void>() {
            public Void call() throws RecorderException {
              getView().exportToSVG(svgName);
              return null;
            }
          };
      ThreadedTaskController.ExceptionHandler exceptionHandler = 
          new ThreadedTaskController.ExceptionHandler() {
            public void handleException(Exception ex) {
              if (!(ex instanceof InterruptedRecorderException)) {
                if (ex instanceof RecorderException) {
                  String message = preferences.getLocalizedString(
                      HomeController.class, "exportToSVGError", svgName);
                  getView().showError(message);
                } else {
                  ex.printStackTrace();
                }
              }
            }
          };
      new ThreadedTaskController(exportToSvgTask, 
          this.preferences.getLocalizedString(HomeController.class, "exportToSVGMessage"), exceptionHandler, 
          this.preferences, this.viewFactory).executeTask(getView());
    }
  }
  }*/
