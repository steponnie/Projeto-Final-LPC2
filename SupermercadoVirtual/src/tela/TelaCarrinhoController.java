/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logica.Carrinho;
import logica.Estoque;
import logica.Produto;

/**
 * FXML Controller class
 *
 * @author hugo
 */
public class TelaCarrinhoController implements Initializable {

    Carrinho carrinho;
    Estoque estoque;
    
    private HashMap<Integer,Produto> productGridPositionTracker;
    //
    private int actualPrefHeight;
    private int actualRow;
    
    //Paineis
    @FXML private GridPane listGridPane;
    @FXML private ScrollPane productList;
    
    @FXML private Button finishBuy;
    @FXML private Button goBack;
    
    //mesma logica do addNewRow anterior
    public void addNewRow(Produto prod){
        actualPrefHeight += 40;
        listGridPane.setPrefHeight(actualPrefHeight);
        actualRow += 1;
        listGridPane.addRow(actualRow);
        
        Button actualRemoveButton = new Button("-");
        actualRemoveButton.setOnAction(event -> {this.removeQtd(event);});
        String quantidade = new String();
        quantidade = String.valueOf(carrinho.getQuantificadorProduto().get(prod)); //transforma a quantidade de cada produto em string
        System.out.println(carrinho.getQuantificadorProduto().get(prod));

        listGridPane.add(new Label(prod.getNome()), 0, actualRow);
        listGridPane.add(new Label(quantidade), 1, actualRow);//adiciona a quantidade de produto na segunda coluna
        listGridPane.add(actualRemoveButton,2,actualRow);
        
        productGridPositionTracker.put(actualRow, prod);
    }
    
    //lista os itens do carrinho
    private void listShoppingCart(){
        carrinho.contarProduto();
        carrinho.getQuantificadorProduto().forEach((produto, quantidade) -> addNewRow(produto));
        carrinho.getQuantificadorProduto().clear();
        
    }
    
    //remove item do carrinho e chama updateShoppingCartList()
    public void removeQtd(ActionEvent ev){
        int productRowIndex = GridPane.getRowIndex((Node)ev.getSource());
        Produto produto = productGridPositionTracker.get(productRowIndex);
        carrinho.removerProduto(produto);
        updateShoppingCartList();
        
    }
    
    //
    public void updateShoppingCartList(){
        listGridPane = new GridPane();
        Label textProduto = new Label("Produto");
        Label textQtd = new Label("Qtd");
        textProduto.setFont(new Font("Ubuntu",15));
        textQtd.setFont(new Font("Ubuntu",15));
        
        listGridPane.add(textProduto, 0, 0);
        listGridPane.add(textQtd, 1, 0);
        
        ColumnConstraints col1Config = new ColumnConstraints(469);
        ColumnConstraints col2Config = new ColumnConstraints(104);
        ColumnConstraints col3Config = new ColumnConstraints(100);
        
        col2Config.setHalignment(HPos.CENTER);
        col3Config.setHalignment(HPos.CENTER);
        
        listGridPane.getColumnConstraints().add(col1Config);
        listGridPane.getColumnConstraints().add(col2Config);
        listGridPane.getColumnConstraints().add(col3Config);
        listGridPane.setPrefHeight(40);
        listGridPane.setPrefWidth(654);
        
        listGridPane.setPadding(new Insets(0,0,0,5));
        GridPane.setHalignment(textProduto, HPos.CENTER);
        GridPane.setHalignment(textQtd, HPos.CENTER);
        
        
        productList.setContent(listGridPane);
        listShoppingCart();
        
    }
    
    
    //Volta para a tela principal
    public void backToMainScreen() throws IOException{
        
        Stage actualStage = (Stage) goBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipal.fxml"));
        Parent root = (Parent)loader.load();
        actualStage.setScene(new Scene(root)); 
    }
    
    //finalizar a compra NAO TEMINEI AINDA
    public void finishBuyPressed(ActionEvent ev) throws IOException{
        Stage actualStage = (Stage) finishBuy.getScene().getWindow();
        String arq = "NotaFiscal.txt";
        String texto = new String();
        texto=	"\tSUPERMERCADO VIRTUAL\n" + "CNPJ: 12.3234.2343 \t Stephanie Gomes\n" +
	"\ttelefone: (31)98002-8922\n\n" + "PRODUTO \t\t quantidade \t preço\n";

        ArquivoTexto.write(arq, texto);
        ArquivoTexto.read(arq);
        actualStage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualPrefHeight = 40;
        actualRow = 0;
        
        this.carrinho = Carrinho.REFERENCIACARRINHO;
        this.estoque = Estoque.REFERENCIAESTOQUE;
        productGridPositionTracker = new HashMap<>();
        
        
        updateShoppingCartList();
    }
    
}
