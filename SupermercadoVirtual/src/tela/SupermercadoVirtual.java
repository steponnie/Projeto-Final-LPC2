/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import logica.*;

/**
 *
 * @author hugo
 */
public class SupermercadoVirtual extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {        
        Parent root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlimentoQuilo a1 = new AlimentoQuilo("AlimentoQuilo1","1111111","Primeiro Alimento Quilo", 
                new Fabricante("Pfizer", "Chama no zap"),10.00,"Grupo1",20.05);
        AlimentoUnitario a2 = new AlimentoUnitario("AlimentoUnitario1","222222","Primeiro Alimento Unitario", 
                new Fabricante("Jansen", "Tbm no zap"),5.00,"Grupo2",2);
        Bebida b1 = new Bebida("Bebida1","33333","Bebida Alcoolica", 
                new Fabricante("nao consigo ler to bebado", "da minha casa"),2.50,30,true);
        Limpeza l1 = new Limpeza("Limpeza1","444444","Veja maxima remocao de gorduras", 
                new Fabricante("veja", "123456789"),35.00,false,"Grupo4");
        
        Estoque estoque = new Estoque();
        Carrinho carrinho = new Carrinho();
        estoque.adicionarProduto(a1);
        estoque.adicionarProduto(a2);
        estoque.adicionarProduto(b1);
        estoque.adicionarProduto(l1);
        
        Estoque.REFERENCIAESTOQUE = estoque;
        Carrinho.REFERENCIACARRINHO = carrinho;
        launch(args);
    }
   
}
