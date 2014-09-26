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
public class Dilma extends Inimigo {

    public Dilma(String img) {
        super(img, 600, 100);
        setHP(30);
        setNome("Dilma");
        setDeslocamento(1);
        iniciarAnimacao();
    }

    @Override
    public void animar() {
        while (getHP() > 0) {
            left();
            //changeImagem("2");
            pausar(100);
            //changeImagem("DEFAULT");            
        }
        new Dinheiro("dinheiro.png", getX(), getY()).iniciarAnimacao();
        setVisible(false);
    }
}
