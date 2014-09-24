/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.itens.Item;

/**
 *
 * @author Danilo
 */
public class Dilma extends Item implements Inimigo {

    public int HP = 100;
    private String nome = "Dilma";

    public Dilma(String img) {
        super(img,600, 100);
        setDeslocamento(1);
        iniciarAnimacao();
    }

    @Override
    public void animar() {
        while (true) {
            left();
            pausar(100);
        }
    }
}
