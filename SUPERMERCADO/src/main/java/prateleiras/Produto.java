package prateleiras;
/**
 * @author eduardo
 */
public abstract class Produto{
    private String nome, codigoBarras;
    private Fabricante fornecedor;
    private double precoFabrica, precoVenda;//fabrica sem impostos, talvez mudar o nom
    private int validade; //dias que faltam pra vencer
    
}
