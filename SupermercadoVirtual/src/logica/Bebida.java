package logica;
/**
 * @author eduardo
 */
public class Bebida {
    public class Bebida extends Produto{
    private double volume, quantidade;
    private boolean alcoolico;

    public Bebida(double volume, double quantidade, boolean alcoolico, String nome, String codigoBarras, Fabricante fornecedor, double precoFabrica, double precoVenda) {
         super(nome, codigoBarras, fornecedor, precoFabrica, precoVenda);
         this.volume = volume;
         this.quantidade = quantidade;
         this.alcoolico = alcoolico;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isAlcoolico() {
        return alcoolico;
    }

    public void setAlcoolico(boolean alcoolico) {
        this.alcoolico = alcoolico;
    }
    
    
    } 
}
