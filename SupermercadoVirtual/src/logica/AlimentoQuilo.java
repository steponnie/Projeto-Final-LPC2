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
public class AlimentoQuilo extends Alimento{
    private double quilo;

    public AlimentoQuilo(String nome, String codigoBarras, String descricao, Fabricante fabricante, double preco, String grupo, double quilo) {
        super(nome, codigoBarras, descricao, fabricante, preco, grupo);
        this.quilo = quilo;
    } 

    public double getQuilo() {
        return quilo;
    }

    public void setQuilo(double quilo) {
        this.quilo = quilo;
    }
    
    @Override
    public void setUnitario() {
        this.unitario = false;
    }
    
    @Override
    public double calculaPreco(){
        return this.preco = this.preco * this.quilo;
    }
    
}
