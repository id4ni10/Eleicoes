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
    
    private int dano;
    
    public Arma(String img) {
        super(img);
    }
    
    public Arma(String img, int x, int y) {
        super(img, x, y);
    }
    
    public int getDano() {
        return dano;
    }
    
    public void setDano(int dano) {
        this.dano = dano;
    }
}
