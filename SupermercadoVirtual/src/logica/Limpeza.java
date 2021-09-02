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
    private String grupo, categoria;//sabonete, shampoo, amaciante...

    public Limpeza(String nome, String codigoBarras, Fabricante fabricante, double preco, String descricao, String grupo) {
        super(nome, codigoBarras, fabricante, preco, descricao);
        this.grupo = grupo;
        this.categoria = "Limpeza";

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
