/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antariksa.fx.roket;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Diffa
 */
public class PeluncuranRoket {
    IntegerProperty luncurID;
    StringProperty tanggal;
    StringProperty namaRoket;
    StringProperty lokasi;

    public PeluncuranRoket(Integer luncurID, String tanggal, String namaRoket, String lokasi) {
        this.luncurID = new SimpleIntegerProperty(luncurID);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.namaRoket = new SimpleStringProperty(namaRoket);
        this.lokasi = new SimpleStringProperty(lokasi);
    }

    public Integer getLuncurID() {
        return luncurID.get();
    }

    public void setLuncurID(Integer luncurID) {
        this.luncurID.set(luncurID);
    }

    public String getTanggal() {
        return tanggal.get();
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }

    public String getNamaRoket() {
        return namaRoket.get();
    }

    public void setNamaRoket(String namaRoket) {
        this.namaRoket.set(namaRoket);
    }

    public String getLokasi() {
        return lokasi.get();
    }

    public void setLokasi(String lokasi) {
        this.lokasi.set(lokasi);
    }
    
    

}
