/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antariksa.fx;

import antariksa.fx.dbase.DBConnector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class CobaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sistem Peluncuran Roket"); //Judul Tab
        Parent root = FXMLLoader.load(getClass().getResource("PeluncuranRoket.fxml"));
        
        Image gmb = new Image(getClass().getResource("Rocket_icon.png").toString());
        ImageView view = new ImageView(gmb);
        view.setPreserveRatio(true);
        view.setFitWidth(120);
        
        VBox tampil = new VBox();
        VBox kosong = new VBox();
        kosong.setBorder(Border.EMPTY);
        tampil.setAlignment(Pos.CENTER);
        tampil.getChildren().addAll(root,view,kosong);
        
        Scene scene = new Scene(tampil);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            try {
            if(null != DBConnector.getConnection("MYSQL")){
            System.out.println("succes");
            } else{
            System.out.println("Gagal");
            } 
            
            //AccountHolderDataModel ahdm = new AccountHolderDataModel("MYSQL");
            //IndividualHolder ih = new IndividualHolder(20,"Abbi","Lampung","male","2002-08-21",new Account(55,5000000.0));
            //ahdm.addAccountHolder(ih);
            //System.out.println("succes");
            
            launch(args);
            } catch (SQLException ex) {
            Logger.getLogger(CobaFX.class.getName()).log(Level.SEVERE, null, ex);
            } 
        /*try {    
            AccountHolderDataModel tes = new AccountHolderDataModel("MYSQL");
            System.out.println(tes.nextAccountHolderID());
        } catch (SQLException ex) {
            Logger.getLogger(CobaFX.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        //launch(args); 
    }
    
}
