/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

/**
 *
 * @author Danilo
 */
public class Tomate extends Arma {

    public Tomate(String img, int x, int y) {
        super(img, x, y);
        setDeslocamento(6);
    }

    @Override
    public int getDano() {
        return 3;
    }
}
