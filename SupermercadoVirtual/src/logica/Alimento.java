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
public abstract class Alimento extends Produto {
    protected boolean unitario; //true eh unitario e false eh a quilo
    private String grupo;//na vdd ou é um ou é outro. secos e frios é quantidade. resto é peso
    
    public Alimento(String nome, String codigoBarras, String descricao, String categoria, Fabricante fabricante, double preco, String grupo) {
        super(nome, codigoBarras, descricao, categoria, fabricante, preco);
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public boolean isUnitario() {
        return unitario;
    }

    public void setUnitario() {
        this.unitario = unitario;
    }
    
    @Override
    public void setCategoria() {
        this.categoria = "alimento";
    }
    
}
