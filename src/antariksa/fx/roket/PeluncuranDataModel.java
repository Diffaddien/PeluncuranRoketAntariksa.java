/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antariksa.fx.roket;

import antariksa.fx.dbase.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Diffa
 */
public class PeluncuranDataModel {
    public final Connection conn;
    
    public PeluncuranDataModel(String driver) throws SQLException {
        this.conn = DBConnector.getConnection(driver);
    }
    
    
    public void addBandar(Bandariksa bandar) throws SQLException{
        String insertBandariksa = "INSERT INTO bandar_antariksa (nama_bandariksa, negara)"
                + "VALUES (?,?)";
        PreparedStatement stmtBandar = conn.prepareStatement(insertBandariksa);
        stmtBandar.setString(1,bandar.getNamaBandar());
        stmtBandar.setString(2,bandar.getNegara());
        stmtBandar.execute();
    }
    
    public void addRoketRobot(RoketRobot robot) throws SQLException{
        String insertRoket = "INSERT INTO roket (nama_roket)"
                + "VALUES (?)";
        PreparedStatement stmtRoket = conn.prepareStatement(insertRoket);
        stmtRoket.setString(1,robot.getRoket());
        stmtRoket.execute();
        
        String insertRobot = "INSERT INTO roket_robot (nama_roket, nama_robot)"
                + "VALUES (?,?)";
        PreparedStatement stmtRobot = conn.prepareStatement(insertRobot);
        stmtRobot.setString(1,robot.getRoket());
        stmtRobot.setString(2,robot.getRobot());
        stmtRobot.execute();
    }
    public void addRoketAstronot(RoketAstronot astro) throws SQLException{
        String insertRoket = "INSERT INTO roket (nama_roket)"
                + "VALUES (?)";
        PreparedStatement stmtRoket = conn.prepareStatement(insertRoket);
        stmtRoket.setString(1,astro.getRoket());
        stmtRoket.execute();
        
        String insertAstro = "INSERT INTO roket_astronot (nama_roket, jumlah_awak)"
                + "VALUES (?,?)";
        PreparedStatement stmtAstro = conn.prepareStatement(insertAstro);
        stmtAstro.setString(1,astro.getRoket());
        stmtAstro.setInt(2,astro.getAwak());
        stmtAstro.execute();
    }
    public void addPeluncuran(PeluncuranRoket luncur) throws SQLException{
        String insertLuncur = "INSERT INTO peluncuran_roket (id_luncur, nama_roket, tanggal, bandariksa)"
                + "VALUES (?,?,?,?)";
        PreparedStatement stmtLuncur = conn.prepareStatement(insertLuncur);
        stmtLuncur.setInt(1,luncur.getLuncurID());
        stmtLuncur.setString(2,luncur.getTanggal());
        stmtLuncur.setString(3,luncur.getNamaRoket());
        stmtLuncur.setString(4,luncur.getLokasi());
        stmtLuncur.execute();
    }
    
    public int nextLuncurID() throws SQLException{
        String sql = "SELECT MAX(id_luncur) from peluncuran_roket";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1)==0?21001:rs.getInt(1)+1;
                }
        return 21001;
    }
    
   public ObservableList<String> getNamaRoket(){
        ObservableList<String> data = FXCollections.observableArrayList();  
        String sql ="SELECT nama_roket FROM roket";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                data.add(rs.getString(1));
                }
        } catch (SQLException ex) {
            Logger.getLogger(PeluncuranDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
   public ObservableList<String> getNamaBandariksa(){
        ObservableList<String> data = FXCollections.observableArrayList();  
        String sql ="SELECT nama_bandariksa FROM bandar_antariksa";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                data.add(rs.getString(1));
                }
        } catch (SQLException ex) {
            Logger.getLogger(PeluncuranDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
   
   public ObservableList<Bandariksa> getDataBandariksa() throws SQLException{
        ObservableList<Bandariksa> data = FXCollections.observableArrayList();  
        String sql ="SELECT nama_bandariksa, negara FROM bandar_antariksa";
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            data.add(new Bandariksa(rs.getString(1),rs.getString(2)));
        }
            
        return data;
    }
   public ObservableList<RoketRobot> getDataRoketRobot() throws SQLException{
        ObservableList<RoketRobot> data = FXCollections.observableArrayList();  
        String sql ="SELECT nama_roket, nama_robot FROM roket_robot";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            data.add(new RoketRobot(rs.getString(1),rs.getString(2)));
        }
            
        return data;
    }
   public ObservableList<RoketAstronot> getDataRoketAstro() throws SQLException{
        ObservableList<RoketAstronot> data = FXCollections.observableArrayList();  
        String sql ="SELECT nama_roket, jumlah_awak FROM roket_astronot";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            data.add(new RoketAstronot(rs.getString(1),rs.getInt(2)));
        }
            
        return data;
    }
    public ObservableList<PeluncuranRoket> getDataLuncur() throws SQLException{
        ObservableList<PeluncuranRoket> data = FXCollections.observableArrayList();  
        String sql ="SELECT id_luncur, nama_roket, tanggal, bandariksa FROM peluncuran_roket";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            data.add(new PeluncuranRoket(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
            
        return data;
    }

}
