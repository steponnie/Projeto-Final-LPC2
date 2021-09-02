/*
Nomes: Eduardo Gomes de Freitas, Higo Antunes Pina, Stéphanie Fonseca de Oliveira gomes Magalhães
*/
package logica;

public class Refrescos extends Produto{

    public Refrescos(String nome, String codigoBarras, Fabricante fornecedor, double preco,  String descricao) {
         super(nome, codigoBarras, fornecedor, preco, descricao);
         this.categoria = "Refrescos";
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria() {
        this.categoria = "Resfrescos";
    }
}
