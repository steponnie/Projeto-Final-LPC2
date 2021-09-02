package logica;
/**
 * @author eduardo
 */
public class Bebida extends Produto{
    private String grupo;
    private String categoria;

    public Bebida(String nome, String codigoBarras, Fabricante fornecedor, double preco,  String descricao, String grupo) {
         super(nome, codigoBarras, fornecedor, preco, descricao);
         this.grupo = grupo;
         this.categoria = "Bebidas";
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
