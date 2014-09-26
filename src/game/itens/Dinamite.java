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
public class Dinamite extends Arma {

    public Dinamite(String img, int x, int y) {
        super(img, x, y);
        setDeslocamento(4);
        setDano(10);

    }
        @Override
    public void animar() {
        
        while (getX() > 0 && isVisible()) { //Enqaunto o tiro não chegar em cim ou acertar um inimigo

            right();
            
            Item i = GameController.getInstance().getColisaoItem(Dilma.class, this);
            
            if (i != null) { //Verifica colisão com o inimigo
                setVisible(false); //Apaga o tiro
                //if (i.getClass().isInstance(Inimigo.class)) {
                    Dilma inimigo = ((Dilma) i);
                    inimigo.setHP(inimigo.getHP() - getDano());
                    System.out.println(getDano());
                    System.out.println(inimigo.getHP());
                    //}

                //i.setVisible(false);
            }
            pausar(20);
        }
        setVisible(false);
    }
}
