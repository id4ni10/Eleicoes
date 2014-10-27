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
public class Dinheiro extends Item{

    public Dinheiro(String img, int x, int y) {
        super(img, x, y);
        setDeslocamento(1);
    }

    @Override
    public void animar() {
        while (getX() > 0 && isVisible()) { //Enqaunto o tiro não chegar em cim ou acertar um inimigo
            left();
            Item i = GameController.getInstance().getColisaoItem(Estudante.class, this);

            if (i != null) { //Verifica colisão com o inimigo
                setVisible(false); //Apaga o tiro
                GameController.getInstance().setFimJogo(true);
            }
            
            pausar(20);
        }
        setVisible(false);
    }
}
