/*
Nomes: Eduardo Gomes de Freitas, Higo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
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

public class TelaCarrinhoController implements Initializable {

    Carrinho carrinho;
    Estoque estoque;
    
    private HashMap<Integer,Produto> productGridPositionTracker;
    
    private int actualPrefHeight;
    private int actualRow;
    
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
        actualRemoveButton.setOnAction(event -> {this.removeQtd(event);});
        String quantidade = new String();
        quantidade = String.valueOf(carrinho.getQuantificadorProduto().get(prod));

        listGridPane.add(new Label(prod.getNome()), 0, actualRow);
        listGridPane.add(new Label(quantidade), 1, actualRow);
        listGridPane.add(actualRemoveButton,2,actualRow);
        
        productGridPositionTracker.put(actualRow, prod);
    }
    
    private void listShoppingCart(){
        carrinho.contarProduto();
        carrinho.getQuantificadorProduto().forEach((produto, quantidade) -> addNewRow(produto));
        carrinho.getQuantificadorProduto().clear();
        
    }
    
    public void removeQtd(ActionEvent ev){
        int productRowIndex = GridPane.getRowIndex((Node)ev.getSource());
        Produto produto = productGridPositionTracker.get(productRowIndex);
        carrinho.removerProduto(produto);
        updateShoppingCartList();
        
    }
    
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
    
    
    public void backToMainScreen() throws IOException{
        
        Stage actualStage = (Stage) goBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipal.fxml"));
        Parent root = (Parent)loader.load();
        actualStage.setScene(new Scene(root)); 
    }
    
    public void finishBuyPressed(ActionEvent ev) throws IOException{
        Stage actualStage = (Stage) finishBuy.getScene().getWindow();
        String arq = "NotaFiscal.txt";
        Notinha arquivo = new Notinha();

        carrinho.contarProduto();
        carrinho.calcularValorCompra();
        double valorTotal = carrinho.getValorCompra();
        
        carrinho.getQuantificadorProduto().forEach((produto,quantidade) -> arquivo.setProdutos(arquivo.getProdutos() +"\n"+
        produto.getNome() + "\t "+ quantidade + "x" + produto.getPreco() + "\t\t R$" + (quantidade*produto.getPreco())  ));
        
        String texto = "\n\tSUPERMERCADO VIRTUAL\n\n" + "CNPJ: 12.3234.2343\n" +
	"Telefone: (31)98002-8922\n\n" + "PRODUTO \t\t QUANTIDADE \t PREÇO\n" +
        arquivo.getProdutos() + "\n\n\t\t\t QUANTIDADE      TOTAL\n" + "\n\t\t\t "+ carrinho.getListaCompra().size() +
        "\t\t R$" + valorTotal + "\n\nAgradecemos a preferência!\n\n" +
        "Tributos Incidentes Lei Federal 12.741/12\nTotal Pago de Imposto - " + String.format("R$%.2f",0.1*valorTotal) + "\nFederal - " + String.format("R$%.2f",0.05*valorTotal)+
        "    Estadual - " + String.format("R$%.2f",0.03*valorTotal) + "    Municipal - " + String.format("R$%.2f",0.02*valorTotal);
        
        Notinha.write(arq, texto);
        Notinha.read(arq);
        actualStage.close();
        
        System.out.println("Sua nota fiscal foi impressa.");
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
