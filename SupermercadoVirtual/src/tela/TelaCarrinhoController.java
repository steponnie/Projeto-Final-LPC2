/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.text.Text;
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
    
    //mesma logica do addNewRow anterior
    public void addNewRow(Produto prod){
        actualPrefHeight += 40;
        listGridPane.setPrefHeight(actualPrefHeight);
        actualRow += 1;
        listGridPane.addRow(actualRow);
        
        Button actualRemoveButton = new Button("-");
        actualRemoveButton.setOnAction(event -> {this.removeFromShoppingCart(event);});

        listGridPane.add(new Label(prod.getNome()), 0, actualRow);
        String quantidade = new String();
        quantidade = String.valueOf(carrinho.getQuantificadorProduto().get(prod)); //transforma a quantidade de cada produto em string
        listGridPane.add(new Label(quantidade), 1, actualRow);//adiciona a quantidade de produto na segunda coluna
        listGridPane.add(actualRemoveButton,2,actualRow);
        
    }
    
    //lista os itens do carrinho
    private void listShoppingCart(){
        carrinho.contarProduto();
        carrinho.getQuantificadorProduto().forEach((produto, quantidade) -> addNewRow(produto));
        carrinho.getQuantificadorProduto().clear();
    }
    
    //remove item do carrinho e chama updateShoppingCartList()
    public void removeFromShoppingCart(ActionEvent ev){
        int productIndex = GridPane.getRowIndex((Node)ev.getSource());
        carrinho.removerProduto(productIndex);
        this.updateShoppingCartList();
    }
    
    //
    public void updateShoppingCartList(){
        //Atualizar o carrinho apos remover itens
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
        Text texto = new Text();
        texto.setText("Cumpom fiscal\n"
                + "produto\t\tquantia\t\tpreço\n");
        ArquivoTexto.write(arq, texto);
        ArquivoTexto.read(arq);
        actualStage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualPrefHeight = 40;
        actualRow = 0;
        
        this.carrinho = Carrinho.REFERENCIACARRINHO;
        
        listShoppingCart();
    }
    
}
/*
ideias futuras

    fazer percorrer todas as linhas do grid e comparar o nome dos textos das labels com o nome dos produtos
            retorna a linha 
    indice do produto é referente a linha do grid em que o produto se encontra


*/
