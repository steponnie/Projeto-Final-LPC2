/*
Nomes: Eduardo Gomes de Freitas, Hugo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/
package logica;

public class Congelados extends Produto {
    
    public Congelados(String nome, String codigoBarras, Fabricante fabricante, double preco, String descricao) {
        super(nome, codigoBarras, fabricante, preco, descricao);
        this.categoria = "Congelados";
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria() {
        this.categoria = "Congelados";
    }
}
