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
public class Tomate extends Item {

    public Tomate(String img, int x, int y) {
        super(img, x, y);
        setDeslocamento(5);
        iniciarAnimacao();
    }

    public void animar() {

        while (getX() > 0 && isVisible()) { //Enqaunto o tiro não chegar em cim ou acertar um inimigo

            right();

            Item i = GameController.getInstance().getColisaoItem(Inimigo.class, this);

            if (i != null) { //Verifica colisão com o inimigo
                setVisible(false); //Apaga o tiro
                i.setVisible(false);
            }

            pausar(20);

        }
        setVisible(false);

    }
}
