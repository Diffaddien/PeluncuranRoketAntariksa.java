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
public class Bandariksa{
    StringProperty namaBandar;
    StringProperty negara;

    public Bandariksa(String namaBandar, String negara) {
        this.namaBandar = new SimpleStringProperty(namaBandar);
        this.negara = new SimpleStringProperty(negara);
    }

    public String getNamaBandar() {
        return namaBandar.get();
    }

    public void setNamaBandar(String namaBandar) {
        this.namaBandar.set(namaBandar);
    }
    
    public String getNegara() {
        return negara.get();
    }

    public void setNegara(String negara) {
        this.namaBandar.set(negara);
    }
    

}
