/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author steph
 */
public class Carrinho {
    
    public static Carrinho REFERENCIACARRINHO;
    
    private double valorCompra;
    private int quantidadeItens;
    private ArrayList<Produto> listaCompra;

    public Carrinho() {
        this.listaCompra  = new ArrayList();
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public ArrayList<Produto> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(ArrayList<Produto> listaCompra) {
        this.listaCompra = listaCompra;
    }
    
    public void adicionarProduto(Produto produto){
        this.listaCompra.add(produto);
    }
    
    public void removerProduto(Produto produto){
        this.listaCompra.remove(produto);
    }
    
    public void removerProduto(int indice){
        this.listaCompra.remove(indice);
    }
    
    public ArrayList<String> listarNomes(){
        ArrayList<String> listaNomes = new ArrayList();
        for(int i = 0; i < this.listaCompra.size(); i++){
            listaNomes.add(this.listaCompra.get(i).getNome());
        }
        return listaNomes;
    }
    
    public void calcularValorCompra(){
        for(int i = 0; i < this.listaCompra.size(); i++){
            this.valorCompra = this.valorCompra + this.listaCompra.get(i).getPreco();
        }
    }
    
    public void calcularQuantidadeItens(){
        this.quantidadeItens = this.listaCompra.size();
    }
}
