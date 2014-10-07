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
public class Cenario extends Item {

    public int direcao = 0;

    public Cenario() {
        super("cenario_game_elevador_noite.png", 0, 0);
        setDeslocamento(1);
    }

    @Override
    public void animar() {
        while (true) { //Enquanto tiver cenário
            //Cenário vai descendo
            if (direcao == 0) {
                left();
            } else {
                right();
            }
            //Tempo para deslocamento do cenário
            pausar(100);
        }
        //if (!GameController.getInstance().isFimJogo()) { //Se o jogo ainda não chegou ao fim
        //  GameController.getInstance().setFimJogo(true);
    }
}
