/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import engine.core.Game;
import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.renders.WindowRender;
import game.itens.Cenario;
import game.itens.Dilma;
import game.itens.Estudante;
import game.itens.Tomate;

/**
 *
 * @author Danilo
 */
public class Eleicoes implements EventosDoRender, EventosDoTeclado {

    private int arma = 1;
    private static Eleicoes instance;
    private Cenario cenario;
    private Estudante estudante;

    private Eleicoes() {

        Game.ALTURA_TELA = 600;
        Game.LARGURA_TELA = 600;

        cenario = new Cenario(); //Cria o cenário de fundo animado
        estudante = new Estudante("cerberuscomplete.gif");
    }

    public void iniciar() {

        cenario.iniciarAnimacao();
        estudante.iniciarAnimacao();
        
        Dilma d = new Dilma("dilma3.gif");
        //d.addImagem("2", "dilma2.png");
        d.iniciarAnimacao();

        WindowRender window = new WindowRender(this, this);
        window.setVisible(true);

        Game.gameInit();
    }

    public static Eleicoes getInstance() {
        if (instance == null) {
            instance = new Eleicoes();
        }
        return instance;
    }

    @Override
    public void antesPintar() {
    }

    @Override
    public void depoisPintar() {
    }

    @Override
    public void teclaPress(int keycode) {
        switch (keycode) {

            case 50:
                arma = 2;
                break;
            case 51:
                arma = 3;
                break;
            case 49:
                arma = 1;
                break;
        }
    }

    @Override
    public void teclaDireita() {
        //cenario.direcao = 0;
        estudante.right();
    }

    @Override
    public void teclaEsquerda() {
        //cenario.direcao = 1;
        estudante.left();
    }

    @Override
    public void teclaCima() {
        estudante.up();
    }

    @Override
    public void teclaBaixo() {
        estudante.down();
    }

    @Override
    public void teclaEspaco() {
        estudante.atirar(arma);
    }
}
