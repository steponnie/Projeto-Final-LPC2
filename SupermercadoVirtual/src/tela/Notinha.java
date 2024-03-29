/*
Nomes: Eduardo Gomes de Freitas, Hugo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/
package tela;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import logica.Carrinho;


public class Notinha {
    private Carrinho carrinho;
    private String produtos;

    public Notinha() {
        this.produtos = "";
    }
    

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }
    
    //método de leitura
    public static String read(String caminhoArquivo){
        String conteudo = "";
        // tentar... 
        try {
            //... criar um arquivo de leitura do caminhoArquivo
            FileReader arq = new FileReader(caminhoArquivo); 
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            //depois vamos tentar ler uma linha
            try{
                linha = lerArq.readLine();
                //enquanto a linha não for nula
                while(linha != null){
                    //concatenaremos a linha lida
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                }
                //se deu certo o arquivo é fechado
                arq.close();
                return conteudo;
            }
            //se nao der certo, o aqruivo recebe a mensagem de erro
            catch(IOException ex){
                System.err.println("Erro: Não foi possível ler o arquivo!\n" + ex);
                return "";
            }
        }
        catch(FileNotFoundException ex){
            System.err.println("Erro: Arquivo não encontrado!\n" + ex);
            return "";
        }
    }
    //método de gravação
    public static boolean write(String caminhoArquivo, String texto){
        try {
            FileWriter arq = new FileWriter(caminhoArquivo);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto);
            gravarArq.close();
            return true;
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
}
