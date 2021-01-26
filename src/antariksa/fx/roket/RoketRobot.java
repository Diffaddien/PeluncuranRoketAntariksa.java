/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antariksa.fx.roket;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Diffa
 */
public class RoketRobot extends Roket {
    StringProperty robot;

    public RoketRobot(String Roket, String robot) {
        super(Roket);
        this.robot = new SimpleStringProperty(robot);
    }
    
    public String getRobot() {
        return robot.get();
    }

    public void setRobot(String robot) {
        this.robot.set(robot);
    }
    

}
