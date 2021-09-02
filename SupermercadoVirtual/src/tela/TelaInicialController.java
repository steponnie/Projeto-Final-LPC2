/*
Nomes: Eduardo Gomes de Freitas, Higo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
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


public class TelaInicialController implements Initializable {
    
    public static String CUSTOMERNAME;
    @FXML
    private TextField customerName;
    
    @FXML
    private Button entrarBtn; 

    public void switchToMainScreen(ActionEvent ev) throws IOException{
        if(!(customerName.getText().equals(""))){
            CUSTOMERNAME = this.customerName.getText();
            Stage actualStage = (Stage) entrarBtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipal.fxml"));
            Parent root = (Parent)loader.load();
            actualStage.setScene(new Scene(root)); 
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
    }    
    
}
