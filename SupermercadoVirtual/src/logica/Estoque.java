/*
Nomes: Eduardo Gomes de Freitas, Hugo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/
package logica;

import java.util.ArrayList;

public class Estoque {
    
    public static Estoque REFERENCIAESTOQUE;
    
    private ArrayList<Produto> listaEstoque;

    public Estoque() {
        this.listaEstoque = new ArrayList();
    }
    
    public void adicionarProduto(Produto produto){
        listaEstoque.add(produto);
    }

    public ArrayList<Produto> getListaEstoque() { 
        return listaEstoque;
    }

    public void setListaEstoque(ArrayList<Produto> listaEstoque) {
        listaEstoque = listaEstoque;
    }
    
    public ArrayList<Produto> categorizarItem(String categoria){
        ArrayList<Produto> itemCategoria = new ArrayList();
        for(int i = 0; i<this.listaEstoque.size(); i++){
            if(this.listaEstoque.get(i).getCategoria().equals(categoria)){
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
    
    public Produto buscarItem(int indice){
        return this.listaEstoque.get(indice);
    }
    
    
}
