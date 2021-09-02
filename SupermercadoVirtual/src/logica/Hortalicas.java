/*
Nomes: Eduardo Gomes de Freitas, Higo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/
package logica;

public class Hortalicas extends Produto {
    
    public Hortalicas(String nome, String codigoBarras, Fabricante fabricante, double preco, String descricao) {
        super(nome, codigoBarras, fabricante, preco, descricao);
        this.categoria = "Hortaliças";
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria() {
        this.categoria = "Hortaliças";
    }
}
