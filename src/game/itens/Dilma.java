/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.core.GameController;

/**
 *
 * @author Danilo
 */
public class Dilma extends Inimigo {

    public Dilma(String img) {
        super(img, 800, 350);
        setHP(30);
        setNome("Dilma");
        setDeslocamento(2);
    }

    @Override
    protected void morri() {
        //new Dinheiro("dinheiro.gif", getX(), getY()).iniciarAnimacao();
        eleicoes2014.Eleicoes.getInstance().mudaFase();
        //Frame.getInstance().fimFase();
                
    }
}
