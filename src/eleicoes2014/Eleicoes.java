/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.itens.Item;
import engine.renders.JPanelRender;
import game.itens.Cenario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Danilo
 */
public class Eleicoes {

    private static Eleicoes instance;
    private JFrame frame;

    private Eleicoes() {
    }

    public void iniciar() {

        Frame frame = Frame.getInstance();
        frame.setVisible(true);
    }

    public void configurar() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(null);

        JPanelRender render = new JPanelRender(frame, new EvtTeclado(), new EvtRender());
        
        render.setLayout(null);
        render.setBorder(BorderFactory.createLineBorder(Color.red));
        JPanel painel = new JPanel(null);
        painel.add(render);

        frame.setContentPane(painel);

        Cenario cenarioEscolha = new Cenario("escolha/telaEscolha.png",1);
        cenarioEscolha.iniciarAnimacao();
        
        render.setBounds(0, 0, cenarioEscolha.getWidth(), cenarioEscolha.getHeight());
        frame.setBounds(0, 0, cenarioEscolha.getWidth() - 5, cenarioEscolha.getHeight());
        
        ImageIcon Escolha1Img = new ImageIcon(getClass().getClassLoader().getResource("resource/escolha/escolha1.png"));
        JButton btnEscolha1 = new JButton(Escolha1Img);
        btnEscolha1.setBorder(BorderFactory.createEmptyBorder());
        
        btnEscolha1.setBounds(10, 10, Escolha1Img.getIconWidth(), Escolha1Img.getIconHeight());
        
        btnEscolha1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                iniciarJogo(1);
            }
        });
        
        ImageIcon escolha2Img = new ImageIcon(getClass().getClassLoader().getResource("resource/escolha/escolha2.png"));
        JButton btnEscolha2 = new JButton(escolha2Img);
        btnEscolha2.setBounds(350, 200, escolha2Img.getIconWidth(), escolha2Img.getIconHeight());
        btnEscolha2.setBorder(BorderFactory.createEmptyBorder());

        btnEscolha2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                
            }
        });
        
        ImageIcon imgEscolha3 = new ImageIcon(getClass().getClassLoader().getResource("resource/escolha/escolha3.png"));
        JButton btEscolha3 = new JButton(imgEscolha3);
        btEscolha3.setBounds(15, 80, imgEscolha3.getIconWidth(), imgEscolha3.getIconHeight());
        btEscolha3.setBorder(BorderFactory.createEmptyBorder());
        btEscolha3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                
            }
        });

        render.add(btnEscolha1);
        render.add(btnEscolha2);
        render.add(btEscolha3);

        frame.setVisible(true);
    }
    
    public void iniciarJogo(int fase){
        frame.setVisible(false);
        iniciar();
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
