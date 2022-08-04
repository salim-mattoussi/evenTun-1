/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionelife;

/**
 *
 * @author wiemhjiri
 */
import entite.Personne;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Statement;
import service.PersonneService;
import util.DataSource;

public class ConnexionElife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

//        DataSource ds1 = DataSource.getInstance();
//        System.out.println(ds1);
//
//        DataSource ds2 = DataSource.getInstance();
//        System.out.println(ds2);
//
//        DataSource ds3 = DataSource.getInstance();
//        System.out.println(ds3);
        PersonneService ps=new PersonneService();
       // ps.addPersonnePst(new Personne("azerty", "prenom", 28));
        System.out.println(ps.readAll());
    }

//    public static void ajouter(Personne p) throws SQLException{
//        String requete="insert into personne (nom,prenom,age) values('"+p.getNom()+"','"+p.getPrenom()+"',"+p.getAge()+")";
//        
//        Statement ste=connection.createStatement();
//        
//        ste.executeUpdate(requete);
//        
//    }
}
