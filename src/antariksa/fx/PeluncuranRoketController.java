/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antariksa.fx;

import antariksa.fx.roket.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ACER
 */
public class PeluncuranRoketController implements Initializable {
    private PeluncuranDataModel pdm;
    
    @FXML
    private Label StatusDB;
    
    @FXML
    private Label DBLabel;

    @FXML
    private TextField bandariksaForm;

    @FXML
    private Button btnAddBandar;

    @FXML
    private Button btnClear;

    @FXML
    private ComboBox<String> boxBNegara;

    @FXML
    private TableView<Bandariksa> Tab_Bandar;
    
    @FXML
    private TableColumn<Bandariksa, String> BNamaBandar;

    @FXML
    private TableColumn<Bandariksa, String> BNegara;
    
    @FXML
    private TableView<RoketRobot> Tab_Robot;
    
    @FXML
    private TableColumn<RoketRobot, String> RRNamaRoket;

    @FXML
    private TableColumn<RoketRobot, String> RRobot;

    @FXML
    private TableView<RoketAstronot> Tab_Astronot;
    
    @FXML
    private TableColumn<RoketAstronot, String> RANamaRoket;

    @FXML
    private TableColumn<RoketAstronot, Integer> RAwak;
    
    @FXML
    private TableView<PeluncuranRoket> Tab_Luncur;
    
    @FXML
    private TableColumn<PeluncuranRoket, Integer> PRIDLuncur;

    @FXML
    private TableColumn<PeluncuranRoket, String> PRoket;

    @FXML
    private TableColumn<PeluncuranRoket, String> PRTanggal;

    @FXML
    private TableColumn<PeluncuranRoket, String> PRBandar;

    @FXML
    private Button btnRefresh2;

    @FXML
    private TextField roketForm;

    @FXML
    private TextField robotForm;

    @FXML
    private Button btnAddRoket;

    @FXML
    private Button btnClear2;

    @FXML
    private Button btnRefresh3;

    @FXML
    private TextField roketForm2;

    @FXML
    private Button btnAddRoket2;

    @FXML
    private Button btnClear3;

    @FXML
    private ComboBox<Integer> boxAwak;

    @FXML
    private Button btnRefresh1;

    @FXML
    private TextField luncurForm;

    @FXML
    private DatePicker tanggal;

    @FXML
    private Button btnAddLuncur;

    @FXML
    private Button btnClear4;

    @FXML
    private ComboBox<String> boxAsalPBandariksa;

    @FXML
    private ComboBox<String> boxAsalRoket;

    @FXML
    private Button btnRefresh4;
    @FXML
    private MenuItem pilihMYSQL;
    @FXML
    private MenuItem pilihSQLITE;
    @FXML
    private MenuButton btnDB;
    

    @FXML
    void handleBandar(ActionEvent event) {
        Bandariksa bd = new Bandariksa(bandariksaForm.getText(), boxBNegara.getValue());
        try {
            pdm.addBandar(bd);
            btnRefresh1.fire();
        } catch (SQLException ex) {
            Logger.getLogger(PeluncuranRoketController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void handleClear(ActionEvent event) {
        bandariksaForm.setText(null);
    }

    @FXML
    void handleClear2(ActionEvent event) {
        roketForm.setText(null);
        robotForm.setText(null);
    }

    @FXML
    void handleClear3(ActionEvent event) throws SQLException {
        roketForm2.setText(null);
    }

    @FXML
    void handleClear4(ActionEvent event) {
        tanggal.setValue(null);
    }

    @FXML
    void handleLuncur(ActionEvent event) {
        PeluncuranRoket pr = new PeluncuranRoket( Integer.parseInt(luncurForm.getText()), boxAsalRoket.getValue(), String.valueOf(tanggal.getValue()), boxAsalPBandariksa.getValue());
        try {
            pdm.addPeluncuran(pr);
            btnRefresh4.fire();
            luncurForm.setText(String.valueOf(pdm.nextLuncurID()));
        } catch (SQLException ex) {
            Logger.getLogger(PeluncuranRoketController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void handleRefresh1(ActionEvent event) throws SQLException {
        ObservableList<Bandariksa> data = pdm.getDataBandariksa();
        BNamaBandar.setCellValueFactory(new PropertyValueFactory<>("namaBandar"));
        BNegara.setCellValueFactory(new PropertyValueFactory<>("negara"));
        Tab_Bandar.setItems(null);
        Tab_Bandar.setItems(data);
        boxAsalRoket.setItems(pdm.getNamaRoket());
        boxAsalPBandariksa.setItems(pdm.getNamaBandariksa());
    }

    @FXML
    void handleRefresh2(ActionEvent event) throws SQLException {
        ObservableList<RoketRobot> data = pdm.getDataRoketRobot();
        RRNamaRoket.setCellValueFactory(new PropertyValueFactory<>("Roket"));
        RRobot.setCellValueFactory(new PropertyValueFactory<>("robot"));
        Tab_Robot.setItems(null);
        Tab_Robot.setItems(data);
        boxAsalRoket.setItems(pdm.getNamaRoket());
        boxAsalPBandariksa.setItems(pdm.getNamaBandariksa());
    }

    @FXML
    void handleRefresh3(ActionEvent event) throws SQLException {
        ObservableList<RoketAstronot> data = pdm.getDataRoketAstro();
        RANamaRoket.setCellValueFactory(new PropertyValueFactory<>("Roket"));
        RAwak.setCellValueFactory(new PropertyValueFactory<>("awak"));
        Tab_Astronot.setItems(null);
        Tab_Astronot.setItems(data);
        boxAsalRoket.setItems(pdm.getNamaRoket());
        boxAsalPBandariksa.setItems(pdm.getNamaBandariksa());
    }

    @FXML
    void handleRefresh4(ActionEvent event) throws SQLException {
        ObservableList<PeluncuranRoket> data = pdm.getDataLuncur();
        PRIDLuncur.setCellValueFactory(new PropertyValueFactory<>("luncurID"));
        PRoket.setCellValueFactory(new PropertyValueFactory<>("namaRoket"));
        PRTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        PRBandar.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        Tab_Luncur.setItems(null);
        Tab_Luncur.setItems(data);
        boxAsalRoket.setItems(pdm.getNamaRoket());
        boxAsalPBandariksa.setItems(pdm.getNamaBandariksa());
    }

    @FXML
    void handleRoket(ActionEvent event) {
        RoketRobot rr = new RoketRobot(roketForm.getText(), robotForm.getText());
        try {
            pdm.addRoketRobot(rr);
            btnRefresh2.fire();
        } catch (SQLException ex) {
            Logger.getLogger(PeluncuranRoketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleRoket2(ActionEvent event) {
        RoketAstronot ra = new RoketAstronot(roketForm2.getText(), boxAwak.getValue());
        try {
            pdm.addRoketAstronot(ra);
            btnRefresh3.fire();
        } catch (SQLException ex) {
            Logger.getLogger(PeluncuranRoketController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    void handleMYSQL(ActionEvent event) throws SQLException {
        pdm = new PeluncuranDataModel("MYSQL");
        DBLabel.setText("MYSQL :");
        StatusDB.setText(pdm.conn==null?"Gagal Terhubung":"Terhubung");
    }
    @FXML
    void handleSQLITE(ActionEvent event) throws SQLException {
        pdm = new PeluncuranDataModel("JDBC");
        DBLabel.setText("SQLITE :");
        StatusDB.setText(pdm.conn==null?"Gagal Terhubung":"Terhubung");
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> negara = FXCollections.observableArrayList("Amerika","Australia","Indonesia","Jepang","Russia","Uni Eropa");
        ObservableList<Integer> awak = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
        boxBNegara.setItems(negara);
        boxAwak.setItems(awak);
        
        try {
            // TODO
            pdm = new PeluncuranDataModel("MYSQL");
            DBLabel.setText("MYSQL :");
            StatusDB.setText(pdm.conn==null?"Gagal Terhubung":"Terhubung");
            System.out.print(pdm.nextLuncurID());
            luncurForm.setText(String.valueOf(pdm.nextLuncurID()));
            boxAsalRoket.setItems(pdm.getNamaRoket());
            boxAsalPBandariksa.setItems(pdm.getNamaBandariksa());
            btnRefresh1.fire();btnRefresh2.fire();btnRefresh3.fire();btnRefresh4.fire();
            
            ObservableList<RoketAstronot> data = pdm.getDataRoketAstro();
            System.out.print(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(PeluncuranRoketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
}
