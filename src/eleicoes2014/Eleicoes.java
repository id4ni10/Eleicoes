/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import engine.core.Game;
import game.itens.Cenario;
import game.itens.Dilma;
import game.itens.Estudante;

/**
 *
 * @author Danilo
 */
public class Eleicoes {

    private int arma = 1;
    private static Eleicoes instance;
    private Cenario cenario;
    private Estudante estudante;

    private Eleicoes() {
        //Game.ALTURA_TELA = 600;
        //Game.LARGURA_TELA = 600;

        
    }

    public void iniciar() {

        cenario = new Cenario(); //Cria o cenário de fundo animado
        estudante = new Estudante("cerberuscomplete.gif");
        
        cenario.iniciarAnimacao();
        estudante.iniciarAnimacao();

        Dilma d = new Dilma("dilma3.gif");
        //d.addImagem("2", "dilma2.png");
        d.iniciarAnimacao();

        //WindowRender window = new WindowRender(this, this);
        Frame frame = Frame.getInstance();
        frame.iniciar();
        frame.setVisible(true);

        Game.setRender(frame.getRenderGame());

        Game.gameInit();
    }

    public static Eleicoes getInstance() {
        if (instance == null) {
            instance = new Eleicoes();
        }
        return instance;
    }
}
