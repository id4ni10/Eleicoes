/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import game.itens.Inimigo;
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
    private final Inimigo chefao;

    /**
     *
     * @param totalInimigos
     * @param chefao
     */
    public GerenciadorInimigos(int totalInimigos, Inimigo chefao) {
        criar = true;
        this.totalInimigos = totalInimigos;
        this.chefao = chefao;
    }

    public synchronized void criaInimigo(boolean criar) {
        this.criar = criar;
    }

    public void criarInimigo() {
        System.out.println("Criando o inimigo: "+ qtdInimigos + " Total: "+ totalInimigos);

        if (criar) {
            Random r = new Random();
            new Suplente("suplente.gif", r.nextInt(100) + 800, r.nextInt(150) + 200).iniciarAnimacao();
            qtdInimigos ++;
        }
        
        if(totalInimigos == qtdInimigos){
            chefao.iniciarAnimacao();
        }
    }

    boolean isTerminou() {
        return totalInimigos >= qtdInimigos;
    }

}
