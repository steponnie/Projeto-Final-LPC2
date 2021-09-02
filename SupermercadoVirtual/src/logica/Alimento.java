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
public class Alimento extends Produto {
    private String categoria, grupo;//na vdd ou é um ou é outro. secos e frios é quantidade. resto é peso
    
    
    public Alimento(String nome, String codigoBarras, Fabricante fabricante, double preco, String descricao, String grupo) {
        super(nome, codigoBarras, fabricante, preco, descricao);
        this.grupo = grupo;
        this.categoria = "Alimentos";
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        this.categoria = categoria;
    }
}
