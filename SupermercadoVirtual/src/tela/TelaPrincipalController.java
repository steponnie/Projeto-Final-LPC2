/*
Nomes: Eduardo Gomes de Freitas, Higo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/
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
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logica.Carrinho;

import logica.Estoque;
import logica.Fabricante;


public class TelaPrincipalController implements Initializable {
    
    private HashMap<Integer,Produto> productListPositionTracker;
    
    Estoque estoque;
    Carrinho carrinho;
    
    private int actualPrefHeight;
    private int actualRow;
    
    @FXML private GridPane listGridPane;
    @FXML private ScrollPane productList;
    @FXML private Pane productInfoPanel;
    
    @FXML private Label olaLabel;
    @FXML private Label nameLabel;
    
    @FXML private Button shoppingCart;
    
    @FXML private Label infoNameField;
    @FXML private Label infoPriceField;
    @FXML private Label infoDescriptionField;
    @FXML private Label infoManufacturerField;
    @FXML private Label infoBarcodeField;
    
    @FXML private ChoiceBox categorias;
    
    
    private void setupChoiceBox(){
        categorias.setOnAction((event) -> FiltrarItem());
        
        categorias.getItems().add("(Nenhum)");
        categorias.getItems().add("Hortaliças");
        categorias.getItems().add("Processados");
        categorias.getItems().add("Congelados");
        categorias.getItems().add("Bebidas Alcoolicas");
        categorias.getItems().add("Refrescos");
        categorias.getItems().add("Higiene Pessoal");
        categorias.getItems().add("Limpeza");
    }
    
    public void FiltrarItem(){
        if((categorias.getValue()).equals("(Nenhum)")){
            updateListaEstoque(estoque.getListaEstoque());
        }
        else{
            ArrayList<Produto> produtosCategorizados = estoque.categorizarItem((String)categorias.getValue());
            updateListaEstoque(produtosCategorizados);
        }
        
    }
    
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
        
        productListPositionTracker.put(actualRow, prod);
    }
    
    public void getProductInfoWindow(ActionEvent event){
        productList.setVisible(false);
        olaLabel.setVisible(false);
        nameLabel.setVisible(false);
        categorias.setVisible(false);
        
        shoppingCart.setVisible(false);
        shoppingCart.isDisabled();
        
        productInfoPanel.setVisible(true);
        int productIndex = GridPane.getRowIndex((Node)event.getSource());
        this.loadProductInfo(productIndex);
        
    }
    
    public void closeProductInfo(){
        productInfoPanel.setVisible(false);
        
        productList.setVisible(true);
        olaLabel.setVisible(true);
        nameLabel.setVisible(true);
        categorias.setVisible(true);
        
        shoppingCart.setVisible(true);
        shoppingCart.isDisabled();
    }
    
    public void loadProductInfo(int index){
        Produto prod = productListPositionTracker.get(index);
        infoNameField.setText("     " + prod.getNome());
        infoPriceField.setText(String.format("     R$%.2f",prod.getPreco()));
        infoDescriptionField.setText("     " + prod.getDescricao());
        infoBarcodeField.setText("      " + prod.getCodigoBarras());
        
        Fabricante fab = prod.getFabricante();
        infoManufacturerField.setText("     " + fab.getNome());
    }
    

    public void switchToShoppingCart() throws IOException{
        Stage actualStage = (Stage)shoppingCart.getScene().getWindow();
        actualStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("TelaCarrinho.fxml")))); 
    }
    
    public void addToShoppingCart(ActionEvent event){
        int productIndex = GridPane.getRowIndex((Node)event.getSource());
        Produto prod = productListPositionTracker.get(productIndex);
        carrinho.adicionarProduto(prod);
    }
    
    public void updateListaEstoque(ArrayList<Produto> produtos){
        listGridPane = new GridPane();
        
        ColumnConstraints col1Config = new ColumnConstraints(338);
        ColumnConstraints col2Config = new ColumnConstraints(211);
        ColumnConstraints col3Config = new ColumnConstraints(52);
        ColumnConstraints col4Config = new ColumnConstraints(52);
        
        col2Config.setHalignment(HPos.CENTER);
        col3Config.setHalignment(HPos.CENTER);
        col4Config.setHalignment(HPos.CENTER);
        
        listGridPane.getColumnConstraints().add(col1Config);
        listGridPane.getColumnConstraints().add(col2Config);
        listGridPane.getColumnConstraints().add(col3Config);
        listGridPane.getColumnConstraints().add(col4Config);
        
        listGridPane.setPrefHeight(40);
        listGridPane.setPrefWidth(654);
        
        listGridPane.setPadding(new Insets(0,0,0,5));        
        productList.setContent(listGridPane);
        
        for(Produto prod : produtos){
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
        
        productListPositionTracker = new HashMap<>();
        
        setupChoiceBox();
        
        updateListaEstoque(estoque.getListaEstoque());
    }    
    
}
