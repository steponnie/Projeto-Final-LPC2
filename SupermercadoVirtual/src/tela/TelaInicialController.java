/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logica.Estoque;

/**
 * FXML Controller class
 *
 * @author hugo
 */
public class TelaInicialController implements Initializable {
    
    private Estoque estoque;
    
    @FXML
    private TextField customerName;
    
    @FXML
    private Button entrarBtn; 

    public void switchToMainScreen(ActionEvent ev) throws IOException{
        if(!(customerName.getText().equals(""))){
            Stage actualStage = (Stage) entrarBtn.getScene().getWindow();
            actualStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipal.fxml"));
            Parent root = (Parent)loader.load();
            TelaPrincipalController controller = loader.getController();
            controller.setUserName(customerName.getText());
            actualStage.show();
            actualStage.setScene(new Scene(root)); 
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}