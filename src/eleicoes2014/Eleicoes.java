/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.renders.JPanelRender;
import game.itens.Cenario;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Danilo
 */
public class Eleicoes {

    private static Eleicoes instance;
    private JFrame frame;

    private Eleicoes() {
    }

    public void iniciarFase1(int tipoEstudante) {
        Fase1 fase1 = Fase1.getInstance();
        fase1.iniciar("cenario_game_elevador_noite.png", tipoEstudante);
        fase1.setVisible(true);
        frame.dispose();
    }

    public void configurar() {
        //final int ALTURA_BTN = 140;
        final int ALTURA_BTN = 140;
        final int ENTRE_ESPACOS = 50;
        final int BORDA_INICIAL = 80;

        final Border bordaRealcada = BorderFactory.createLineBorder(Color.RED, 5);
        final Border border = BorderFactory.createEmptyBorder();

        frame = new JFrame();

        frame.setLayout(null);

        JPanelRender render = new JPanelRender(frame, new EvtTeclado(), new EvtRender());

        render.setLayout(null);
        JPanel painel = new JPanel(null);
        painel.add(render);

        frame.setContentPane(painel);

        Cenario cenarioEscolha = new Cenario("escolha/background.png", 0);

        cenarioEscolha.iniciarAnimacao();

        render.setBounds(0, 0, cenarioEscolha.getWidth(), cenarioEscolha.getHeight());
        frame.setBounds(0, 0, cenarioEscolha.getWidth() - 5, cenarioEscolha.getHeight());

        ImageIcon Escolha1Img = new ImageIcon(getClass().getClassLoader().getResource("resource/escolha/escolha1.png"));

        final JLabel btnEscolha1 = new JLabel(Escolha1Img);
        btnEscolha1.setBounds(BORDA_INICIAL, ALTURA_BTN, Escolha1Img.getIconWidth(), Escolha1Img.getIconHeight());
        btnEscolha1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                iniciarFase1(1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnEscolha1.setBorder(bordaRealcada);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnEscolha1.setBorder(border);
            }
        });

        ImageIcon escolha2Img = new ImageIcon(getClass().getClassLoader().getResource("resource/escolha/escolha2.png"));
        final JLabel btnEscolha2 = new JLabel(escolha2Img);
        final int x = BORDA_INICIAL + Escolha1Img.getIconWidth() + ENTRE_ESPACOS;
        btnEscolha2.setBounds(x, ALTURA_BTN, escolha2Img.getIconWidth(), escolha2Img.getIconHeight());

        btnEscolha2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                iniciarFase1(2);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnEscolha2.setBorder(bordaRealcada);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnEscolha2.setBorder(border);

            }
        });

        ImageIcon imgEscolha3 = new ImageIcon(getClass().getClassLoader().getResource("resource/escolha/escolha3.png"));
        final JLabel btEscolha3 = new JLabel(imgEscolha3);
        final int x2 = x + escolha2Img.getIconWidth() + ENTRE_ESPACOS;
        btEscolha3.setBounds(x2, ALTURA_BTN, imgEscolha3.getIconWidth(), imgEscolha3.getIconHeight());
        btEscolha3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                iniciarFase1(3);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btEscolha3.setBorder(bordaRealcada);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btEscolha3.setBorder(border);
            }
        });

        render.add(btnEscolha1);
        render.add(btnEscolha2);
        render.add(btEscolha3);

        frame.setVisible(true);
    }

    public static Eleicoes getInstance() {
        if (instance == null) {
            instance = new Eleicoes();
        }
        return instance;
    }

    private class EvtTeclado implements EventosDoTeclado {

        @Override
        public void teclaPress(int keycode) {
        }

        @Override
        public void teclaDireita() {
        }

        @Override
        public void teclaEsquerda() {
        }

        @Override
        public void teclaCima() {
        }

        @Override
        public void teclaBaixo() {
        }

        @Override
        public void teclaEspaco() {
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
        }

        @Override
        public void depoisPintar() {
        }
    }
}
