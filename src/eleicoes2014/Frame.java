/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import engine.core.GameController;
import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.renders.JPanelRender;
import game.itens.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Danilo
 */
public class Frame extends JFrame {

    private JPanel[] options;
    private JPanelRender renderGame;
    private int arma = 1;
    private static Frame instance;
    private Cenario cenario;
    private Estudante estudante;
    private int fase = 0;
    private List<Cenario> cenarios;

    private GerenciadorInimigos gerenciadorInimigo;

    private Frame() {
        //initComponents();
        this.setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void fimFase() {
        System.out.println("Chamado Fim Fase");
        fase += 1;

        cenario.fimFase();
        cenario.setVisible(false);
        estudante.setVisible(false);
        gerenciadorInimigo.criaInimigo(false);
        GameController.getInstance().delItens();

        if (fase == 3) {
            GameController.getInstance().setFimJogo(true);
        } else {
            iniciarFase();
        }

    }

    public static Frame getInstance() {
        if (instance == null) {
            instance = new Frame();
            instance.iniciar();
        }
        return instance;
    }

    public JPanel[] getOptions() {
        return options;
    }

    public void iniciar() {

        cenarios = this.createCenarios();
        gerenciadorInimigo = new GerenciadorInimigos();
        iniciarFase();
        criaInimigos();
    }

    public void iniciarFase() {
        System.out.println("Iniciando a fase: " + fase);
        cenario = cenarios.get(fase);

        estudante = new Estudante("estudante_animado.gif");

        initComponents();

        cenario.iniciarAnimacao();

        estudante.iniciarAnimacao();

        new Dilma("dilma3.gif").iniciarAnimacao();
//        new Aecio("aecio.gif", 700, 250).iniciarAnimacao();
        //new Marina("marina.gif", 600, 200).iniciarAnimacao();
        //new Suplente("suplente.gif", 900, 275).iniciarAnimacao();

        gerenciadorInimigo.criaInimigo(true);

    }

    public void criaInimigos() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    while (!GameController.getInstance().fimjogo) {
                        gerenciadorInimigo.criarInimigo();
                        Thread.sleep(8000);
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Erro ao criar inimigo");
                }
            }
        }).start();

    }

    public JPanelRender getRenderGame() {
        return renderGame;
    }

    public final void initComponents() {

        options = new JPanel[3];

        renderGame = new JPanelRender(this, new EvtTeclado(), new EvtRender());
        renderGame.setBorder(BorderFactory.createLineBorder(Color.red));
        renderGame.setBounds(80, 0, 750, 550);

        options[0] = new JPanel();
        options[0].setBounds(0, 150, 80, 50);
        options[0].setBorder(BorderFactory.createTitledBorder("B. de papel"));
        options[0].add(new JLabel(estudante.getBolasDePapel() + ""));

        options[1] = new JPanel();
        options[1].setBounds(0, 200, 80, 50);
        options[1].setBorder(BorderFactory.createTitledBorder("Tomates"));
        options[1].add(new JLabel(estudante.getTomates() + ""));

        options[2] = new JPanel();
        options[2].setBounds(0, 250, 80, 50);
        options[2].setBorder(BorderFactory.createTitledBorder("Bombas"));
        options[2].add(new JLabel(estudante.getDinamites() + ""));

        JPanel pnl = new JPanel(null);
        pnl.add(options[0]);
        pnl.add(options[1]);
        pnl.add(options[2]);
        pnl.add(renderGame);

        setContentPane(pnl);
    }

    private List<Cenario> createCenarios() {
        List<Cenario> cenarios = new ArrayList<>();
        cenarios.add(new Cenario("cenario_game_elevador_noite.png", 1));
        cenarios.add(new Cenario("cidade_manha_estendido.png", 2));
        cenarios.add(new Cenario("Cristocompleto.png", 3));
        return cenarios;
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
            estudante.right();
        }

        @Override
        public void teclaEsquerda() {
            estudante.left();
        }

        @Override
        public void teclaCima() {
            System.out.println(estudante.getY());
            if (estudante.getY() > 210) {
                estudante.up();
            }

        }

        @Override
        public void teclaBaixo() {
            System.out.println(estudante.getY());
            if (estudante.getY() < 410) {
                estudante.down();
            }
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
        public void antesPintar() {
            gerenciadorInimigo.criaInimigo(false);
        }

        @Override
        public void depoisPintar() {
            gerenciadorInimigo.criaInimigo(true);
        }

    }
}
