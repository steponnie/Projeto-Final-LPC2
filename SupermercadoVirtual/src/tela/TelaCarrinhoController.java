/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logica.Carrinho;
import logica.Estoque;
import logica.Fabricante;
import logica.Produto;

/**
 * FXML Controller class
 *
 * @author hugo
 */
public class TelaCarrinhoController implements Initializable {

    Carrinho carrinho;
    
    //
    private int actualPrefHeight;
    private int actualRow;
    
    //Paineis
    @FXML private GridPane listGridPane;
    @FXML private ScrollPane productList;
    
    @FXML private Button finishBuy;
    @FXML private Button goBack;
    
    
    public void addNewRow(Produto prod){
        actualPrefHeight += 40;
        listGridPane.setPrefHeight(actualPrefHeight);
        actualRow += 1;
        listGridPane.addRow(actualRow);
        
        Button actualRemoveButton = new Button("-");
        actualRemoveButton.setOnAction(event -> {this.removeFromShoppingCart(event);});
        
        listGridPane.add(new Label(prod.getNome()), 0, actualRow);
        listGridPane.add(actualRemoveButton,1,actualRow);
    }
    
    private void listShoppingCart(){
        ArrayList<Produto> myCart = this.carrinho.getListaCompra();
        for(Produto prod : myCart){
            addNewRow(prod);
        }
    }
    
    public void updateShoppingCartList(){
        while(listGridPane.getRowConstraints().size() > 0){
            listGridPane.getRowConstraints().remove(0);
        }

        while(listGridPane.getColumnConstraints().size() > 0){
            listGridPane.getColumnConstraints().remove(0);
        }
        listShoppingCart();
    }
    
    public void backToMainScreen() throws IOException{
        Stage actualStage = (Stage) goBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipal.fxml"));
        Parent root = (Parent)loader.load();
        actualStage.setScene(new Scene(root)); 
    }
    
    
    
    public void removeFromShoppingCart(ActionEvent ev){
        int productIndex = GridPane.getRowIndex((Node)ev.getSource());
        carrinho.removerProduto(productIndex);
        this.updateShoppingCartList();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualPrefHeight = 40;
        actualRow = 0;
        
        this.carrinho = Carrinho.REFERENCIACARRINHO;
        
        listShoppingCart();
    }
    
}
