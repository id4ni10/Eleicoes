/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

/**
 *
 * @author Danilo
 */
public class Suplente extends Inimigo {

    public Suplente(String img, int x, int y) {
        super(img, x, y);
        setHP(30);
        setNome("Suplente");
        setDeslocamento(4);
    }

    @Override
    protected void morri() {
        new Dinheiro("dinheiro.gif", getX(), getY()).iniciarAnimacao();
    }
}
