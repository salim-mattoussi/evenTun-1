/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author wiemhjiri
 */
import entite.Personne;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.DataSource;

public class PersonneService implements Iservice<Personne> {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PersonneService() {
        cnx = DataSource.getInstance().getConnection();
    }


    public void addPersonnePst(Personne p) throws SQLException {
        String requete = "insert into personne (nom,prenom,age) values(?,?,?)";

        pst = cnx.prepareStatement(requete);

        pst.setString(1, p.getNom());
        pst.setString(2, p.getPrenom());
        pst.setInt(3, p.getAge());

        pst.executeUpdate();

    }

    public ArrayList<Personne> readAll() {
         ArrayList<Personne> list = new ArrayList<>();
        try {
            String requete = "select * from personne";
           
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Personne p = new Personne(rs.getInt(1), rs.getString(2), rs.getString("prenom"), rs.getInt("age"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void add(Personne p) {
        String requete = "insert into personne (nom,prenom,age) values('" + p.getNom() + "','" + p.getPrenom() + "'," + p.getAge() + ")";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personne readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
