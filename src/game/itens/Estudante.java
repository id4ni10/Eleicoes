/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.core.GameController;
import engine.itens.Item;
import java.awt.print.Paper;
import java.util.List;
import sun.swing.PrintColorUIResource;

/**
 *
 * @author Danilo
 */
public class Estudante extends Item {

    private int tomates = 3;
    private int bolasDePapel = 0;
    private int dinamites = 0;

    public Estudante(String img) {
        super(img);
        setDeslocamento(3);
    }

    public void atirar(int arma) {
        switch (arma) {
            case 1:
                if (bolasDePapel > 0) {
                    bolasDePapel--;
                    new BolaDePapel("bala.jpg", getX() + 24, getY() - 50);
                } else {

                    System.out.println("acabaram os papeis");
                }
                break;
            case 2:
                if (tomates > 0) {
                    tomates--;
                    new Tomate("tomate.png", getX() + 24, getY() - 50);
                } else {
                    System.out.println("acabaram os tomates");
                }
                break;
            case 3:
                dinamites--;
                new Tomate("bala.jpg", getX() + 24, getY() - 50);
                break;
        }
    }

    @Override
    public void animar() {
        Item i = GameController.getInstance().getColisaoItem(Tomate.class, this);
        if (i != null) {
            tomates++;
        }
    }
}
