/*
Nomes: Eduardo Gomes de Freitas, Hugo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/
package logica;

public abstract class Produto{
    private String nome, codigoBarras;
    protected String categoria, descricao;
    private Fabricante fabricante;
    protected double preco;
    

    public Produto(String nome, String codigoBarras, Fabricante fabricante, double preco, String descricao) {
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        this.categoria = categoria;
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
