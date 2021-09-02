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
        
        Estoque estoque = new Estoque();
        Carrinho carrinho = new Carrinho();
        
        Fabricante f1 = new Fabricante("Hortinha Feliz", "Pombo Correio");
        Fabricante f2 = new Fabricante("Solteirao", "Chama no Zap");
        Fabricante f3 = new Fabricante("Bebum da Esquina", "So gritar");
        Fabricante f4 = new Fabricante("Perola Frufru", "So hora marcada");
        Fabricante f5 = new Fabricante("Casa Suja", "Chao sujo");
        Fabricante f6 = new Fabricante("Hinode", "Inbox");
        
        
        estoque.adicionarProduto(new Alimento("Batata de Rostinho  ", "1234", f1, 03.50, "Uma batata que tem rostinho!!", "Hortaliças"));
        estoque.adicionarProduto(new Alimento("Cup Noodles         ", "5623", f2, 4.00, "Pra quem te preguiça até de fazer miojo.", "Processados"));
        estoque.adicionarProduto(new Alimento("Feijao Rosinha      ", "3448", f1, 8.00, "Feijão Kawaii.", "Grãos"));
        estoque.adicionarProduto(new Alimento("Pizza Congelada     ", "7945", f2, 15.00, "Ta dificil a situação ne...", "Congelados"));
        estoque.adicionarProduto(new Alimento("RestoDontê          ", "6165", f2, 10.00, "O resto de ontem.", "Congelados"));
        estoque.adicionarProduto(new Alimento("Moranguinho Especial", "4512", f1, 13.00, "É tipo um morango so que melhor.", "Hortaliças"));
        estoque.adicionarProduto(new Alimento("Erva Medicinal      ", "7463", f1, 50.00, "( ͡° ͜ʖ ͡°)", "Hortaliças"));
        estoque.adicionarProduto(new Alimento("Arroz Instantâneo   ", "6410", f2, 2.50, "Ainda é arroz, eu acho.", "Processados"));
        estoque.adicionarProduto(new Alimento("Bicoito Bolacha     ", "7512", f1, 1.50, "Socialize seus farelos pela casa.", "Hortaliças"));
        estoque.adicionarProduto(new Alimento("Marmitex Fitness    ", "6512", f2, 20.00, "Pra ficar fortinho.", "Congelados"));
        
        estoque.adicionarProduto(new Bebida("Breja                 ", "6542", f3, 2.00, "Ceva.", "Alcoolicos"));
        estoque.adicionarProduto(new Bebida("Nectar Alcoolico      ", "3279", f4, 70.00, "Ui, ele compra bebida importada.", "Alcoolicos"));
        estoque.adicionarProduto(new Bebida("Cachaça Suspeita      ", "8462", f3, 1.00, "404 Not Found", "Alcoolicos"));
        estoque.adicionarProduto(new Bebida("Sake de Arroz         ", "3015", f4, 55.00, "Então você assiste anime??", "Alcoolicos"));
        estoque.adicionarProduto(new Bebida("Cabuata               ", "4912", f3, 4.50, "O melhor trabalho do Aquaman.", "Alcoolicos"));
        estoque.adicionarProduto(new Bebida("Uísque de Patrão      ", "6874", f4, 1000.00, "Estamos em choque com o preço.", "Alcoolicos"));
        estoque.adicionarProduto(new Bebida("Agua da Torneira      ", "6463", f3, 3.00, "É a Água Voss mas sem a garrafa bonita. ", "Refrescos"));
        estoque.adicionarProduto(new Bebida("Suco de Mexerica      ", "3487", f3, 2.00, "Que tem gosto de tamarillo.", "Refrescos"));
        estoque.adicionarProduto(new Bebida("Toddynho do Riquinho  ", "1467", f4, 30.00, "Pra seu filho ostentar no recreio.", "Refrescos"));
        estoque.adicionarProduto(new Bebida("Agua Voss             ", "1983", f4, 30.00, "É a àgua da Torneira numa garrafa bonita.", "Refrescos"));
        
        estoque.adicionarProduto(new Limpeza("Sabão Limpão         ", "6487", f6, 7.00, "Pra ficar tinindo.", "Higiene Pessoal"));
        estoque.adicionarProduto(new Limpeza("Agua Sanitaria Area  ", "3924", f5, 18.00, "Pra deixar tudo estelelizado.", "Limpeza"));
        estoque.adicionarProduto(new Limpeza("Shampum              ", "6132", f6, 11.00, "Era pra ser cheiroso.", "Higiene Pessoal"));
        estoque.adicionarProduto(new Limpeza("Condicionador Bom    ", "9863", f6, 10.00, "Na verdade é ok.", "Higiene Pessoal"));
        estoque.adicionarProduto(new Limpeza("Amaciante Gigante    ", "8321", f5, 15.00, "Atenção: o tamanho é normal.", "LImpeza"));
        estoque.adicionarProduto(new Limpeza("Dètergent            ", "4452", f5, 9.00, "Le français est très chic.", "Limpeza"));
        estoque.adicionarProduto(new Limpeza("Alcool em Gel        ", "9542", f6, 10.00, "Sai Corona.", "Higiene Pessoal"));
        estoque.adicionarProduto(new Limpeza("BoomBril             ", "5332", f5, 3.00, "Um estouro de limpeza", "Limpeza"));
        estoque.adicionarProduto(new Limpeza("Creme em Gel         ", "3154", f6, 14.50, "Mas é creme ou é gel?", "Higiene Pessoal"));
        estoque.adicionarProduto(new Limpeza("Olhe                 ", "1734", f5, 13.50, "Melhor que o concorrente.", "Limpeza"));
        
        
        
       
        
        Estoque.REFERENCIAESTOQUE = estoque;
        Carrinho.REFERENCIACARRINHO = carrinho;
        launch(args);
    }
   
}
