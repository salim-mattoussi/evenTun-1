/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Personne;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.PersonneService;

/**
 * FXML Controller class
 *
 * @author wiemhjiri
 */
public class ListPersonneController implements Initializable {

    @FXML
    private Label labnom;
    @FXML
    private TableView<Personne> table;
    @FXML
    private TableColumn<Personne, Integer> col_id;
    @FXML
    private TableColumn<Personne, String> col_nom;
    @FXML
    private TableColumn<Personne, String> col_prenom;
    @FXML
    private TableColumn<Personne, Integer> col_age;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        remplirTab();
    }

    public void setLabnom(String labnom) {
        this.labnom.setText(labnom);
    }

    public void remplirTab() {
        PersonneService ps = new PersonneService();
        ArrayList<Personne> list = ps.readAll();

        ObservableList<Personne> obs = FXCollections.observableArrayList(list);

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        table.setItems(obs);

    }

}
