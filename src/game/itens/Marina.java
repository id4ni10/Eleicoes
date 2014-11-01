/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import eleicoes2014.Fase1;

/**
 *
 * @author Danilo
 */
public class Marina extends Inimigo {

    public Marina(String img, int x, int y) {
        super(img, x, y);
        setHP(30);
        setNome("Marina");
        setDeslocamento(2);
    }

    @Override
    protected void morri() {
        Fase1.getInstance().mudaFase();
    }
}
