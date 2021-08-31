
package tela;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import logica.Carrinho;

import logica.Estoque;
import logica.Fabricante;


/**
 * FXML Controller class
 *
 * @author hugo
 */
public class TelaPrincipalController implements Initializable {
    
    Estoque estoque;
    Carrinho carrinho;
    
    //
    private int actualPrefHeight;
    private int actualRow;
    
    //Paineis
    @FXML private GridPane listGridPane;
    @FXML private ScrollPane productList;
    @FXML private Pane productInfoPanel;
    
    //Labels
    @FXML private Label olaLabel;
    @FXML private Label nameLabel;
    
    //Botoes
    @FXML private Button shoppingCart;
    
    @FXML private Label infoNameField;
    @FXML private Label infoPriceField;
    @FXML private Label infoDescriptionField;
    @FXML private Label infoManufacturerField;
    @FXML private Label infoBarcodeField;
    
    
    
    public void addNewRow(Produto prod){
        actualPrefHeight += 40;
        listGridPane.setPrefHeight(actualPrefHeight);
        actualRow += 1;
        listGridPane.addRow(actualRow);
        
        Button actualAddButton = new Button("+");
        Button actualInfoButton = new Button("i");
        actualInfoButton.setOnAction(event -> {this.getProductInfoWindow(event);});
        actualAddButton.setOnAction(event -> {this.addToShoppingCart(event);});
        
        listGridPane.add(new Label(prod.getNome()), 0, actualRow);
        listGridPane.add(new Label(prod.getCategoria()), 1, actualRow);
        listGridPane.add(actualAddButton,2,actualRow);
        listGridPane.add(actualInfoButton,3,actualRow);
    }
    
    public void getProductInfoWindow(ActionEvent event){
        productList.setVisible(false);
        olaLabel.setVisible(false);
        nameLabel.setVisible(false);
        
        shoppingCart.setVisible(false);
        shoppingCart.isDisabled();
        
        productInfoPanel.setVisible(true);
        int productIndex = GridPane.getRowIndex((Node)event.getSource());
        this.loadProductInfo(productIndex-1);
        
    }
    
    public void loadProductInfo(int index){
        Produto prod = estoque.buscarItem(index);
        infoNameField.setText(prod.getNome());
        infoPriceField.setText(String.format("R$%.2f",prod.getPreco()));
        infoDescriptionField.setText(prod.getDescricao());
        infoBarcodeField.setText(prod.getCodigoBarras());
        
        Fabricante fab = prod.getFabricante();
        infoManufacturerField.setText(fab.getNome());
    }
    
    public void closeProductInfo(){
        productInfoPanel.setVisible(false);
        
        productList.setVisible(true);
        olaLabel.setVisible(true);
        nameLabel.setVisible(true);
        
        shoppingCart.setVisible(true);
        shoppingCart.isDisabled();
    }
    
    public void switchToShoppingCart() throws IOException{
        Stage actualStage = (Stage)shoppingCart.getScene().getWindow();
        actualStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("TelaCarrinho.fxml")))); 
    }
    
    public void addToShoppingCart(ActionEvent event){
        int productIndex = GridPane.getRowIndex((Node)event.getSource());
        Produto prod = estoque.buscarItem(productIndex-1);
        carrinho.adicionarProduto(prod);
    }
    
    public void initializeEstoque(){
        ArrayList<Produto> produtosDisponiveis = estoque.getListaEstoque();
        printEstoque(produtosDisponiveis);
    }
    
    private void printEstoque(ArrayList<Produto> produtosDisponiveis){
        for(Produto prod : produtosDisponiveis){
            this.addNewRow(prod);
        }
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualPrefHeight = 40;
        actualRow = 0;
        
        this.nameLabel.setText(TelaInicialController.CUSTOMERNAME);
        this.estoque = Estoque.REFERENCIAESTOQUE;
        this.carrinho = Carrinho.REFERENCIACARRINHO;
        
        initializeEstoque();
    }    
    
}
