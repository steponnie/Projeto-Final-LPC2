/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author steph
 */
public class AlimentoUnitario extends Alimento{
    private int quantidade;

    public AlimentoUnitario(String nome, String codigoBarras, String descricao,String categoria, Fabricante fabricante, double preco, String grupo, int quantidade) {
        super(nome, codigoBarras, descricao, categoria, fabricante, preco, grupo);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public void setUnitario() {
        this.unitario = true;
    }
    
    @Override
    public double calculaPreco(){
        return this.preco = this.preco * this.quantidade;
    }
}
