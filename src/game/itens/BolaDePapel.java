/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

/**
 *
 * @author Danilo
 */
public class BolaDePapel extends Arma {

    public BolaDePapel(String img, int x, int y) {
        super(img, x, y);
        setDeslocamento(3);
    }

    @Override
    public int getDano() {
        return 1;
    }
}
