/*
Nomes: Eduardo Gomes de Freitas, Hugo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/

package tela;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import logica.*;

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
        
        
        estoque.adicionarProduto(new Hortalicas("Batata de Rostinho  ", "1234", f1, 03.50, "Uma batata que tem rostinho!!"));
        estoque.adicionarProduto(new Processados("Cup Noodles         ", "5623", f2, 4.00, "Pra quem tem preguiça até de fazer miojo."));
        estoque.adicionarProduto(new Hortalicas("Feijao Rosinha      ", "3448", f1, 8.00, "Feijão Kawaii."));
        estoque.adicionarProduto(new Congelados("Pizza Congelada     ", "7945", f2, 15.00, "Ta dificil a situação ne..."));
        estoque.adicionarProduto(new Congelados("RestoDontê          ", "6165", f2, 10.00, "O resto de ontem."));
        estoque.adicionarProduto(new Hortalicas("Moranguinho Especial", "4512", f1, 13.00, "É tipo um morango, só que melhor."));
        estoque.adicionarProduto(new Hortalicas("Erva Medicinal      ", "7463", f1, 50.00, "( ͡° ͜ʖ ͡°)"));
        estoque.adicionarProduto(new Processados("Arroz Instantâneo   ", "6410", f2, 2.50, "Ainda é arroz, eu acho."));
        estoque.adicionarProduto(new Processados("Bicoito Bolacha     ", "7512", f1, 1.50, "Socialize seus farelos pela casa."));
        estoque.adicionarProduto(new Congelados("Marmitex Fitness    ", "6512", f2, 20.00, "Pra ficar fortinho."));
        
        estoque.adicionarProduto(new Bebidas("Breja                 ", "6542", f3, 2.00, "Ceva."));
        estoque.adicionarProduto(new Bebidas("Nectar Alcoolico      ", "3279", f4, 70.00, "Ui, ele compra bebida importada."));
        estoque.adicionarProduto(new Bebidas("Cachaça Suspeita      ", "8462", f3, 1.00, "404 Not Found"));
        estoque.adicionarProduto(new Bebidas("Sake de Arroz         ", "3015", f4, 55.00, "Então você assiste anime??"));
        estoque.adicionarProduto(new Bebidas("Cabuata               ", "4912", f3, 4.50, "O melhor trabalho do Aquaman."));
        estoque.adicionarProduto(new Bebidas("Uísque de Patrão      ", "6874", f4, 1000.00, "Estamos em choque com o preço."));
        estoque.adicionarProduto(new Refrescos("Agua da Torneira      ", "6463", f3, 3.00, "É a Água Voss mas sem a garrafa bonita. "));
        estoque.adicionarProduto(new Refrescos("Suco de Mexerica      ", "3487", f3, 2.00, "Que tem gosto de tamarillo."));
        estoque.adicionarProduto(new Refrescos("Toddynho do Riquinho  ", "1467", f4, 30.00, "Pra seu filho ostentar no recreio."));
        estoque.adicionarProduto(new Refrescos("Agua Voss             ", "1983", f4, 30.00, "É a água da Torneira numa garrafa bonita."));
        
        estoque.adicionarProduto(new Higiene("Sabão Limpão         ", "6487", f6, 7.00, "Pra ficar tinindo."));
        estoque.adicionarProduto(new Limpeza("Agua Sanitaria Area  ", "3924", f5, 18.00, "Pra deixar com cheiro de piscina."));
        estoque.adicionarProduto(new Higiene("Shampum              ", "6132", f6, 11.00, "Era pra ser cheiroso."));
        estoque.adicionarProduto(new Higiene("Condicionador Bom    ", "9863", f6, 10.00, "Na verdade é ok."));
        estoque.adicionarProduto(new Limpeza("Amaciante Gigante    ", "8321", f5, 15.00, "Atenção: o tamanho é normal."));
        estoque.adicionarProduto(new Limpeza("Dètergent            ", "4452", f5, 9.00, "Le français est très chic."));
        estoque.adicionarProduto(new Higiene("Alcool em Gel        ", "9542", f6, 10.00, "Sai Corona."));
        estoque.adicionarProduto(new Limpeza("BoomBril             ", "5332", f5, 3.00, "Um estouro de limpeza."));
        estoque.adicionarProduto(new Higiene("Creme em Gel         ", "3154", f6, 14.50, "Mas é creme ou é gel?"));
        estoque.adicionarProduto(new Limpeza("Olhe                 ", "1734", f5, 13.50, "Melhor que o concorrente."));
        
        
        Estoque.REFERENCIAESTOQUE = estoque;
        Carrinho.REFERENCIACARRINHO = carrinho;
        launch(args);
    }
   
}
