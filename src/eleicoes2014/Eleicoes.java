/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import engine.core.GameController;
import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.renders.JPanelRender;
import game.itens.Cenario;
import game.itens.Estudante;
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
    private int fase = 1;
    

    private Eleicoes() {
    }

    public void iniciar(int fase) {

        switch (fase) {
            case 1:
                Fase1 fase1 = Fase1.getInstance();
                fase1.iniciar("cenario_game_elevador_noite.png");
                fase1.setVisible(true);
                break;
            case 2:
                Fase2 fase2 = Fase2.getInstance();
                fase2.iniciar("cidade_manha_estendido.png");
                fase2.setVisible(true);
                break;
            case 3:
                Fase3 fase3 = Fase3.getInstance();
                fase3.iniciar("cidade_manha_estendido.png");
                fase3.setVisible(true);
                break;
        }
    }

    public void configurar() {
        //final int ALTURA_BTN = 140;
        final int ALTURA_BTN = 140;
        final int ENTRE_ESPACOS = 50;
        final int BORDA_INICIAL = 80;
        
        final Border bordaRealcada = BorderFactory.createLineBorder(Color.RED,5);
        final Border border = BorderFactory.createEmptyBorder();
                
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        JPanelRender render = new JPanelRender(frame, new EvtTeclado(), new EvtRender());

        render.setLayout(null);
        JPanel painel = new JPanel(null);
        painel.add(render);

        frame.setContentPane(painel);

//<<<<<<< HEAD
//        Cenario cenarioEscolha = new Cenario("escolha/telaEscolha.png", 1);
//=======
        Cenario cenarioEscolha = new Cenario("escolha/background.png",0);
//>>>>>>> origin/master
        cenarioEscolha.iniciarAnimacao();

        render.setBounds(0, 0, cenarioEscolha.getWidth(), cenarioEscolha.getHeight());
        frame.setBounds(0, 0, cenarioEscolha.getWidth() - 5, cenarioEscolha.getHeight());

        ImageIcon Escolha1Img = new ImageIcon(getClass().getClassLoader().getResource("resource/escolha/escolha1.png"));
//<<<<<<< HEAD
//        JButton btnEscolha1 = new JButton(Escolha1Img);
//        btnEscolha1.setBorder(BorderFactory.createEmptyBorder());
//
//        btnEscolha1.setBounds(10, 10, Escolha1Img.getIconWidth(), Escolha1Img.getIconHeight());
//
//        btnEscolha1.addActionListener(new ActionListener() {
//=======
        final JLabel btnEscolha1 = new JLabel(Escolha1Img);
        btnEscolha1.setBounds(BORDA_INICIAL, ALTURA_BTN, Escolha1Img.getIconWidth(), Escolha1Img.getIconHeight());
        btnEscolha1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Estudante estudante = new Estudante("personagens/Personagem1.png");
                iniciarJogo(estudante);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnEscolha1.setBorder(bordaRealcada);
            }
//>>>>>>> origin/master

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
                Estudante estudante = new Estudante("personagens/Personagem2.png");
                iniciarJogo(estudante);
            }
            
             @Override
            public void mouseEntered(MouseEvent e) {
                btnEscolha2.setBorder(bordaRealcada);
            }

            @Override
//<<<<<<< HEAD
  //          public void actionPerformed(ActionEvent ev) {
//=======
            public void mouseExited(MouseEvent e) {
                btnEscolha2.setBorder(border);
//>>>>>>> origin/master
            }
        });

        ImageIcon imgEscolha3 = new ImageIcon(getClass().getClassLoader().getResource("resource/escolha/escolha3.png"));
        final JLabel btEscolha3 = new JLabel(imgEscolha3);
        final int x2 = x + escolha2Img.getIconWidth() + ENTRE_ESPACOS;
        btEscolha3.setBounds(x2, ALTURA_BTN, imgEscolha3.getIconWidth(), imgEscolha3.getIconHeight());
        btEscolha3.addMouseListener(new MouseAdapter(){

            @Override
//<<<<<<< HEAD
//            public void actionPerformed(ActionEvent ev) {
//=======
            public void mouseReleased(MouseEvent e) {
                Estudante estudante = new Estudante("personagens/Personagem3.png");
                iniciarJogo(estudante);
//>>>>>>> origin/master
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
//<<<<<<< HEAD

    //public void iniciarJogo(int fase) {
//=======
    
    
    public void iniciarJogo(Estudante estudante){
//>>>>>>> origin/master
        frame.setVisible(false);
        iniciar(fase);
    }

    public static Eleicoes getInstance() {
        if (instance == null) {
            instance = new Eleicoes();
        }
        return instance;
    }

    public void mudaFase() {
        
        frame.setVisible(false);

        fase += 1;
        GameController.getInstance().setFimJogo(true);
        iniciar(fase);
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
