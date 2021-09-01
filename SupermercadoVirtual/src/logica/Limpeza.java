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
public class Limpeza extends Produto {
    protected boolean corporal; //true eh higiene pessoal e false eh higienizacao de ambiente
    private String grupo;//sabonete, shampoo, amaciante...

    public Limpeza(String nome, String codigoBarras, String descricao, String categoria, Fabricante fabricante, double preco, boolean corporal, String grupo) {
        super(nome, codigoBarras, descricao, categoria, fabricante, preco);
        this.corporal = corporal;
        this.grupo = grupo;
    }

    public boolean isCorporal() {
        return corporal;
    }

    public void setCorporal(boolean corporal) {
        this.corporal = corporal;
    } 

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    @Override
    public void setCategoria() {
        this.categoria = "limpeza";
    }
}
