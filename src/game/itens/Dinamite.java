/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

/**
 *
 * @author Danilo
 */
public class Dinamite extends Arma {

    public Dinamite(String img, int x, int y) {
        super(img, x, y);
        setDeslocamento(4);

    }

    @Override
    public int getDano() {
        return 10;
    }
}
