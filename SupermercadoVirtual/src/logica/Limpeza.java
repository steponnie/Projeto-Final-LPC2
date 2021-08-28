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
public class Limpeza extends Higiene{

    public Limpeza(String nome, String codigoBarras, Fabricante fabricante, double preco, String grupo) {
        super(nome, codigoBarras, fabricante, preco, grupo);
    }
    
    @Override
    public void setCorporal() {
        this.corporal = false;
    }
    
}
