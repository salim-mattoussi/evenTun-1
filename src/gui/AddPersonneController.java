/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Personne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.PersonneService;

/**
 * FXML Controller class
 *
 * @author wiemhjiri
 */
public class AddPersonneController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtage;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void valider(ActionEvent event) throws IOException {
            Personne p=new Personne(txtnom.getText(), txtprenom.getText(), Integer.parseInt(txtage.getText()));
            
            PersonneService ps=new PersonneService();
            ps.add(p);
            
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ListPersonne.fxml"));
            
            Parent root=loader.load();
            
            ListPersonneController controller=loader.getController();
            
            controller.setLabnom(txtnom.getText());
            
            txtprenom.getScene().setRoot(root);
            
            
            
    }
    
}
