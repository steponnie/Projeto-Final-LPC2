package logica;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author steph
 */
public class Carrinho {
    
    public static Carrinho REFERENCIACARRINHO;
    
    private double valorCompra;
    private int quantidadeItens;
    private ArrayList<Produto> listaCompra;
    private HashMap<Produto, Integer> quantificadorProduto;

    public Carrinho() {
        this.listaCompra  = new ArrayList();
        this.quantificadorProduto = new HashMap<>();
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
    
    public HashMap<Produto, Integer> getQuantificadorProduto() {
        return quantificadorProduto;
    }

    public void setQuantificadorProduto(HashMap<Produto, Integer> quantificadorProduto) {
        this.quantificadorProduto = quantificadorProduto;
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
    
    public void contarProduto(){ //coloca todos os produtos adicionados no carrinho em um hashmap, sendo a key o produto e o value a quantidade
        for(int i = 0; i < this.listaCompra.size(); i++){
            if(this.quantificadorProduto.containsKey(this.listaCompra.get(i))){
                this.quantificadorProduto.replace(this.listaCompra.get(i), this.quantificadorProduto.get(this.listaCompra.get(i))+1);
            }
            else{
                this.quantificadorProduto.put(this.listaCompra.get(i), 1);
            }
        }
    }
}
