/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.core.GameController;
import engine.itens.Item;

/**
 *
 * @author Danilo
 */
public class Estudante extends Aliado {
    
    public Estudante(String img) {
        super(img);
        setX(100);
        setY(320);
        setDeslocamento(5);
    }
    
    @Override
    public void animar() {
        Item i = GameController.getInstance().getColisaoItem(Tomate.class, this);
        if (i != null) {
            setTomates(getTomates() + 1);
        }
    }
}
