
package tela;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import logica.Produto;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import logica.AlimentoQuilo;
import logica.AlimentoUnitario;
import logica.Bebida;

import logica.Estoque;
import logica.Fabricante;
import logica.Limpeza;


/**
 * FXML Controller class
 *
 * @author hugo
 */
public class TelaPrincipalController implements Initializable {

    
    private int actualPrefHeight;
    private int actualRow;
    
    @FXML
    private GridPane listGridPane;
    @FXML
    private ScrollPane productList;
    @FXML
    private Label olaLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Button shoppingCart;
    @FXML
    private Pane productInfoPanel;
    
    
    public void addNewRow(Produto prod){
        actualPrefHeight += 40;
        listGridPane.setPrefHeight(actualPrefHeight);
        actualRow += 1;
        listGridPane.addRow(actualRow);
        
        Button actualAddButton = new Button("+");
        Button actualInfoButton = new Button("i");
        actualInfoButton.setOnAction(event -> {this.getProductInfo();});
        actualAddButton.setOnAction(event -> {this.addToShoppingCart();});
        
        listGridPane.add(new Label(prod.getNome()), 0, actualRow);
        listGridPane.add(new Label(prod.getCategoria()), 1, actualRow);
        listGridPane.add(actualAddButton,2,actualRow);
        listGridPane.add(actualInfoButton,3,actualRow);
    }
    
    public void getProductInfo(){
        productList.setVisible(false);
        olaLabel.setVisible(false);
        nameLabel.setVisible(false);
        
        shoppingCart.setVisible(false);
        shoppingCart.isDisabled();
        
        productInfoPanel.setVisible(true);
    }
    
    public void closeProductInfo(){
        productList.setVisible(true);
        olaLabel.setVisible(true);
        nameLabel.setVisible(true);
        
        shoppingCart.setVisible(true);
        shoppingCart.isDisabled();
        
        productInfoPanel.setVisible(false);
    }
    
    public void switchToShoppingCart(){
        
    }
    
    public void addToShoppingCart(){
        
    }
    
    public void setUserName(String name){
        this.nameLabel.setText(name);
    }
    
    public void initializeEstoque(){

        ArrayList<Produto> produtosDisponiveis = Estoque.getListaEstoque();
        printEstoque(produtosDisponiveis);
    }
    
    private void printEstoque(ArrayList<Produto> produtosDisponiveis){
        for(Produto prod : produtosDisponiveis){
            System.out.println(prod.getNome());
            this.addNewRow(prod);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualPrefHeight = 40;
        actualRow = 0;
        initializeEstoque();
    }    
    
}
