/*
Nomes: Eduardo Gomes de Freitas, Hugo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/
package logica;

public class Processados extends Produto {
    
    public Processados(String nome, String codigoBarras, Fabricante fabricante, double preco, String descricao) {
        super(nome, codigoBarras, fabricante, preco, descricao);
        this.categoria = "Processados";
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria() {
        this.categoria = "Processados";
    }
}
