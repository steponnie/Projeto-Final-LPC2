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
public class Estoque {
    private static ArrayList<Produto> listaEstoque;

    public Estoque() {
        this.listaEstoque = new ArrayList();
    }
    
    public void adicionarProduto(Produto produto){
        listaEstoque.add(produto);
    }

    public static ArrayList<Produto> getListaEstoque() { 
        return listaEstoque;
    }

    public void setListaEstoque(ArrayList<Produto> listaEstoque) {
        listaEstoque = listaEstoque;
    }
    
    public ArrayList<Produto> categorizarItem(String categoria){
        ArrayList<Produto> itemCategoria = new ArrayList();
        for(int i = 0; i<this.listaEstoque.size(); i++){
            if(this.listaEstoque.get(i).categoria.equals(categoria)){
                itemCategoria.add(this.listaEstoque.get(i));
            }
        }
        return itemCategoria;
    }
    
    public Produto buscarItem(String dado){
        for(int i = 0; i<this.listaEstoque.size(); i++){
            if(this.listaEstoque.get(i).getNome().equals(dado) || this.listaEstoque.get(i).getCodigoBarras().equals(dado)){
                return this.listaEstoque.get(i);
            }
        }
        return null;
    }
}
