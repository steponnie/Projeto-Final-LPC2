
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
    private int actualPrefHeight; //tamanho total do GridPane
    private int actualRow; //referencia a ultima coluna criada
    
    //Paineis
    @FXML private GridPane listGridPane; //GridPane que compoe a lista
    @FXML private ScrollPane productList;
    @FXML private Pane productInfoPanel; //Painel com informacoes do produto
    
    //Labels
    @FXML private Label olaLabel;
    @FXML private Label nameLabel;
    
    //Botoes
    @FXML private Button shoppingCart;
    
    //
    @FXML private Label infoNameField;
    @FXML private Label infoPriceField;
    @FXML private Label infoDescriptionField;
    @FXML private Label infoManufacturerField;
    @FXML private Label infoBarcodeField;
    
    
    //Adiciona nova linha com as informações do produto
    public void addNewRow(Produto prod){
        actualPrefHeight += 40; 
        listGridPane.setPrefHeight(actualPrefHeight); //aumenta tamanho total do grid
        actualRow += 1;
        listGridPane.addRow(actualRow);//cria nova coluna
        
        //cria botoes + e i
        Button actualAddButton = new Button("+"); 
        Button actualInfoButton = new Button("i");
        //configura botoes para reagir a eventos
        actualInfoButton.setOnAction(event -> {this.getProductInfoWindow(event);});
        actualAddButton.setOnAction(event -> {this.addToShoppingCart(event);});
        
        //preenche o grid
        listGridPane.add(new Label(prod.getNome()), 0, actualRow);
        listGridPane.add(new Label(prod.getCategoria()), 1, actualRow);
        listGridPane.add(actualAddButton,2,actualRow);
        listGridPane.add(actualInfoButton,3,actualRow);
    }
    
    //Desliga a visualizacao dos itens e liga a visualizacao do painel de informacoes
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
    
    //Liga a visualizacao dos itens e desliga a visualizacao do painel de informacoes
    public void closeProductInfo(){
        productInfoPanel.setVisible(false);
        
        productList.setVisible(true);
        olaLabel.setVisible(true);
        nameLabel.setVisible(true);
        
        shoppingCart.setVisible(true);
        shoppingCart.isDisabled();
    }
    
    //carrega as informacoes do produto e preenche os campos de informacao
    public void loadProductInfo(int index){
        Produto prod = estoque.buscarItem(index);
        infoNameField.setText(prod.getNome());
        infoPriceField.setText(String.format("R$%.2f",prod.getPreco()));
        infoDescriptionField.setText(prod.getDescricao());
        infoBarcodeField.setText(prod.getCodigoBarras());
        
        Fabricante fab = prod.getFabricante();
        infoManufacturerField.setText(fab.getNome());
    }
    

    //muda a cena para Meu carrinho
    public void switchToShoppingCart() throws IOException{
        Stage actualStage = (Stage)shoppingCart.getScene().getWindow();
        actualStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("TelaCarrinho.fxml")))); 
    }
    
    //adiciona item para o carrinho
    public void addToShoppingCart(ActionEvent event){
        int productIndex = GridPane.getRowIndex((Node)event.getSource());
        Produto prod = estoque.buscarItem(productIndex-1);
        carrinho.adicionarProduto(prod);
    }
    
    //Inicializa o Estoque: Pega a array e cria a lista
    public void initializeEstoque(){
        ArrayList<Produto> produtosDisponiveis = estoque.getListaEstoque();
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
