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
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Danilo
 */
public class Fase2 extends JFrame {

    private JPanel[] options;
    private JPanelRender renderGame;
    private int arma = 1;
    private static Fase2 instance;
    private Cenario cenario;
    private int tipoEstudante;
    private Estudante estudante;
    private GerenciadorInimigos gerenciadorInimigo;

    private Fase2() {
        //initComponents();
        this.setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static Fase2 getInstance() {
        if (instance == null) {
            instance = new Fase2();
            //instance.iniciar();
        }
        return instance;
    }

    public JPanel[] getOptions() {
        return options;
    }

    public void iniciar(String img,EventosDoTeclado evtTeclado, int tipoEstudante) {
        gerenciadorInimigo = new GerenciadorInimigos(15, new Aecio("aecio.gif", 700, 250));

        System.out.println("Iniciando a fase: 2");
        cenario = new Cenario(img, 2);
        this.tipoEstudante = tipoEstudante;
        this.estudante = Estudante.criar(tipoEstudante);

        initComponents(evtTeclado);

        cenario.iniciarAnimacao();

        this.estudante.iniciarAnimacao();

        //gerenciadorInimigo.criaInimigo(true);
        criaInimigos();
    }

    public void criaInimigos() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    while (!gerenciadorInimigo.isTerminou()) {
                        gerenciadorInimigo.criarInimigo();
                        Thread.sleep(8000);
                        //GameController.getInstance().delItens();
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

    public final void initComponents(EventosDoTeclado evtTeclado) {

        options = new JPanel[3];

        renderGame = new JPanelRender(this, evtTeclado, new EvtRender());
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
