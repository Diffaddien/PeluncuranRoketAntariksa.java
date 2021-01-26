/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antariksa.fx.roket;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author ale
 */
public class RoketAstronot extends Roket{
    IntegerProperty awak;

    public RoketAstronot(String Roket, int awak) {
        super(Roket);
        this.awak = new SimpleIntegerProperty(awak);
    }

    public Integer getAwak() {
        return awak.get();
    }

    public void setAwak(Integer awak) {
        this.awak.set(awak);
    }
    
    

}
