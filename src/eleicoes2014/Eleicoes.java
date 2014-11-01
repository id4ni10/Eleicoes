/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes2014;

import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.itens.Item;
import engine.renders.JPanelRender;
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
        frame.setBounds(0, 0, 800, 600);
        frame.setLayout(null);

        JPanelRender render = new JPanelRender(frame, new EvtTeclado(), new EvtRender());
        render.setBounds(0, 0, 800, 600);
        render.setLayout(null);
        render.setBorder(BorderFactory.createLineBorder(Color.red));
        JPanel painel = new JPanel(null);
        painel.add(render);

        frame.setContentPane(painel);

        new Item("choice.png", 0, 0) {
        }.iniciarAnimacao();

        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("resource/dilma3.gif"));
        JButton btnEstudante = new JButton(img);
        btnEstudante.setBorder(BorderFactory.createEmptyBorder());
        
        btnEstudante.setBounds(336, 243, img.getIconWidth(), img.getIconHeight());
        
        btnEstudante.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                iniciarJogo(1);
            }
        });
        
//        JButton btnDonaDeCasa = new JButton(new ImageIcon(getClass().getClassLoader().getResource("resource/donadecasa.gif")));
//        btnDonaDeCasa.setBounds(15, 80, 50, 50);
//
//        btnDonaDeCasa.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ev) {
//                
//            }
//        });

        render.add(btnEstudante);
        //render.add(btnDonaDeCasa);

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
