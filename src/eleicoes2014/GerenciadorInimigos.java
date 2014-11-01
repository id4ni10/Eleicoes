/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import game.itens.Suplente;
import java.util.Random;

/**
 *
 * @author koonjshah
 */
public class GerenciadorInimigos {

    private final int totalInimigos;
    
    private boolean criar;
    private int qtdInimigos;

    public GerenciadorInimigos(int totalInimigos) {
        criar = true;
        this.totalInimigos = totalInimigos;
    }

    public synchronized void criaInimigo(boolean criar) {
        this.criar = criar;
    }

    public void criarInimigo() {

        if (criar || totalInimigos >= qtdInimigos) {
            Random r = new Random();
            new Suplente("suplente.gif", r.nextInt(100) + 800, r.nextInt(150) + 200).iniciarAnimacao();
            qtdInimigos ++;
        }
    }

}
