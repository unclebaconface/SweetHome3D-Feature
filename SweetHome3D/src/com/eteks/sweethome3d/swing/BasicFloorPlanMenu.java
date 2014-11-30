package com.eteks.sweethome3d.swing;

import java.awt.event.ActionEvent;
import com.eteks.sweethome3d.*;
import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.UserPreferences;
import com.eteks.sweethome3d.viewcontroller.HomeController;
import javax.swing.AbstractAction;

public class BasicFloorPlanMenu extends AbstractAction{
  BasicFloorPlanComponent component;
  public BasicFloorPlanMenu(String title){
    super(title);
    
    component = HomePane.getBasicComponent();
  }
  public void actionPerformed(ActionEvent e){
    component.drawBasicFloorPlan();
    component.exportFloorPlan();
  }
}
