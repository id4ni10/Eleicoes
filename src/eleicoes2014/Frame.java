/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.renders.JPanelRender;
import game.itens.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Danilo
 */
public class Frame extends JFrame {

    private JPanel options;
    private JPanelRender renderGame;
    private int arma = 1;
    private static Frame instance;
    private Cenario cenario;
    private Estudante estudante;

    private Frame() {
        initComponents();
        this.setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static Frame getInstance() {
        if (instance == null) {
            instance = new Frame();
            instance.iniciar();
        }
        return instance;
    }

    public void iniciar() {


        cenario = new Cenario();
        estudante = new Estudante("cerberuscomplete.gif");

        cenario.iniciarAnimacao();
        estudante.iniciarAnimacao();

        new Dilma("dilma3.gif").iniciarAnimacao();
        new Aecio("aecio.gif", 700, 250).iniciarAnimacao();
        new Marina("marina.gif", 600, 200).iniciarAnimacao();
        new Suplente("suplente.gif", 900, 275).iniciarAnimacao();
    }

    public JPanelRender getRenderGame() {
        return renderGame;
    }

    public final void initComponents() {
        renderGame = new JPanelRender(this, new EvtTeclado(), new EvtRender());
        renderGame.setBorder(BorderFactory.createLineBorder(Color.red));
        renderGame.setBounds(50, 0, 750, 550);

        options = new JPanel();
        options.setBounds(0, 0, 50, 50);
        options.setBorder(BorderFactory.createLineBorder(Color.yellow));

        JPanel pnl = new JPanel(null);
        pnl.add(options);

        pnl.add(renderGame);

        setContentPane(pnl);
    }

    private class EvtTeclado implements EventosDoTeclado {

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

        @Override
        public void antesPintar() {
        }

        @Override
        public void depoisPintar() {
        }
    }

    private class EvtRender implements EventosDoRender {

        @Override
        public void depoisPintar() {
        }

        @Override
        public void antesPintar() {
        }
    }
}
