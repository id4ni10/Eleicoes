/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.itens.Item;

/**
 *
 * @author Danilo
 */
public class Cenario extends Item {

    private int direcao = 0;

    public Cenario(String img, int deslocamento) {
        super(img, 0, 0);
        setDeslocamento(deslocamento);
    }

    public Cenario() {
        super("cenario_game_elevador_noite.png", 0, 0);
        setDeslocamento(1);
    }

    @Override
    public void animar() {
        while (true) { //Enquanto tiver cenário
            left();
            //Tempo para deslocamento do cenário
            pausar(100);
        }
    }
}
