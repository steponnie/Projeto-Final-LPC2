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
public class Higiene extends Produto {
    protected boolean corporal; //true eh higiene pessoal e false eh higienizacao de ambiente
    private String grupo;//sabonete, shampoo, amaciante...
    

    public Higiene(String nome, String codigoBarras, Fabricante fabricante, double preco, boolean corporal, String grupo) {
        super(nome, codigoBarras, fabricante, preco);
        this.corporal = corporal;
        this.grupo = grupo;
    }
    
    @Override
    public void setTipo(){
        this.isAlimento = false;
        this.isHigiene = true;
        this.isBebida = false;
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
    
}
