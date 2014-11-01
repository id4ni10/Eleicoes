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
public abstract class Arma extends Item {

    public Arma(String img) {
        super(img);
    }

    public abstract int getDano();

    public Arma(String img, int x, int y) {
        super(img, x, y);
    }

    @Override
    public void animar() {
        while (getX() > 0 && isVisible()) {
            right();
            Inimigo i = (Inimigo) GameController.getInstance().getColisaoItem(Inimigo.class, this);

            if (i != null) {
                i.setHP(i.getHP() - getDano());
                atingiu();
            }
            pausar(20);
        }
        atingiu();
    }
    
    
    private void atingiu(){
        setVisible(false);
    }
}
