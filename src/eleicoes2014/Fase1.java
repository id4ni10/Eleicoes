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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Danilo
 */
public class Fase1 extends JFrame {

    private JPanel[] options;
    private JPanelRender renderGame;
    private int arma = 1;
    private static Fase1 instance;
    private Cenario cenario;
    private Estudante estudante;
    private int tipoEstudante;
    private GerenciadorInimigos gerenciadorInimigo;

    private Fase1() {
        //initComponents();
        this.setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static Fase1 getInstance() {
        if (instance == null) {
            instance = new Fase1();
        }
        return instance;
    }

    public JPanel[] getOptions() {
        return options;
    }

    public void iniciar(String img, int tipoEstudante) {
        gerenciadorInimigo = new GerenciadorInimigos(2, new Marina("marina.gif", 600, 200));
        this.tipoEstudante = tipoEstudante;
        this.estudante = Estudante.criar(tipoEstudante);

        System.out.println("Iniciando a fase: 1");
        cenario = new Cenario(img, 1);

        initComponents();

        cenario.iniciarAnimacao();

        this.estudante.iniciarAnimacao();

        gerenciadorInimigo.criarInimigo();
    }

    public void criaInimigos() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    while (!GameController.getInstance().fimjogo || !gerenciadorInimigo.isTerminou()) {
                        gerenciadorInimigo.criarInimigo();
                        Thread.sleep(8000);
                    }
                    System.out.println("Terminei de criar os inimigos");
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
        final JLabel lblPapel = new JLabel(estudante.getBolasDePapel() + "");
        options[0].add(lblPapel);

        options[1] = new JPanel();
        options[1].setBounds(0, 200, 80, 50);
        options[1].setBorder(BorderFactory.createTitledBorder("Tomates"));
        final JLabel lblTomate = new JLabel(estudante.getTomates() + "");
        options[1].add(lblTomate);

        options[2] = new JPanel();
        options[2].setBounds(0, 250, 80, 50);
        options[2].setBorder(BorderFactory.createTitledBorder("Bombas"));
        final JLabel lblBomba = new JLabel(estudante.getDinamites() + "");
        options[2].add(lblBomba);

        JPanel pnl = new JPanel(null);
        pnl.add(options[0]);
        pnl.add(options[1]);
        pnl.add(options[2]);
        pnl.add(renderGame);

        estudante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int arma = (int) e.getSource();

                switch (arma) {
                    case 1:
                        lblPapel.setText(estudante.getBolasDePapel() + "");
                        break;
                    case 2:
                        lblTomate.setText(estudante.getTomates()+ "");
                        break;
                    case 3:
                        lblBomba.setText(estudante.getDinamites() + "");
                }
            }

        });

        setContentPane(pnl);
    }

    public void mudaFase() {
        cenario.setVisible(false);
        estudante.setVisible(false);

        GameController.getInstance().delItens();

        Fase2 fase2 = Fase2.getInstance();
        fase2.iniciar("cidade_manha_estendido.png", new EvtTeclado(), tipoEstudante);
        fase2.setVisible(true);
        this.dispose();

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
            if (estudante.getX() < 660) {
                estudante.right();
            }
        }

        @Override
        public void teclaEsquerda() {
            if (estudante.getX() > 0) {
                estudante.left();
            }
        }

        @Override
        public void teclaCima() {
            if (estudante.getY() > 210) {
                estudante.up();
            }

        }

        @Override
        public void teclaBaixo() {
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
            gerenciadorInimigo.criaInimigo(false);
        }

        @Override
        public void depoisPintar() {
            gerenciadorInimigo.criaInimigo(true);
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
