package logica;
/**
 * @author eduardo
 */
public class Bebida extends Produto{
    private double quantidade;
    private boolean alcoolico;

    public Bebida(String nome, String codigoBarras, String descricao, Fabricante fornecedor, double preco, double quantidade, boolean alcoolico) {
         super(nome, codigoBarras, descricao, fornecedor, preco);
         this.quantidade = quantidade;
         this.alcoolico = alcoolico;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public void setCategoria() {
        this.categoria = "bebida";
    }

    public boolean isAlcoolico() {
        return alcoolico;
    } 

    public void setAlcoolico(boolean alcoolico) {
        this.alcoolico = alcoolico;
    }
}
