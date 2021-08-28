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
public abstract class Produto{
    protected boolean isAlimento, isHigiene, isDecoracao;
    private String nome, codigoBarras;
    private Fabricante fabricante;
    protected double preco;

    public Produto(String nome, String codigoBarras, Fabricante fabricante, double preco) {
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.fabricante = fabricante;
        this.preco = preco;
    }
    
    public void setTipo(){
        this.isAlimento = isAlimento;
        this.isHigiene = isHigiene;
        this.isDecoracao = isDecoracao;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public double calculaPreco(){ 
        return this.preco;
    }
    
}
