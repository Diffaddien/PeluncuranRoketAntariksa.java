/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antariksa.fx.roket;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author ale
 */
public class Roket{
    StringProperty roket;

    public Roket( String Roket) {
        this.roket = new SimpleStringProperty(Roket);
    }

    public String getRoket() {
        return roket.get();
    }

    public void setRoket(String roket) {
        this.roket.set(roket);
    }    

}
