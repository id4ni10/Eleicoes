/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.itens.Item;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public abstract class Aliado extends Item {
    
    private List<ActionListener> actions;

    public int getBolasDePapel() {
        return bolasDePapel;
    }

    public void setBolasDePapel(int bolasDePapel) {
        this.bolasDePapel = bolasDePapel;
    }

    public int getDinamites() {
        return dinamites;
    }

    public void setDinamites(int dinamites) {
        this.dinamites = dinamites;
    }

    public int getTomates() {
        return tomates;
    }

    public void setTomates(int tomates) {
        this.tomates = tomates;
    }
    private int tomates = 3;
    private int bolasDePapel = 10;
    private int dinamites = 10;

    public Aliado(String img, int x, int y) {
        super(img, x, y);
        this.actions = new ArrayList<>();
    }

    public Aliado(String img) {
        super(img);
        this.actions = new ArrayList<>();
    }
    
    public void addActionListener(ActionListener actionListener){
        this.actions.add(actionListener);
    }

    public void atirar(int arma) {
        switch (arma) {
            case 1:
                if (getBolasDePapel() > 0) {
                    setBolasDePapel(getBolasDePapel() - 1);
                    new BolaDePapel("papel_animado.gif", getX() + 40, getY() + 55).iniciarAnimacao();
                } else {
                    System.out.println("acabaram os papeis");
                }
                break;
            case 2:
                if (getTomates() > 0) {
                    setTomates(getTomates() - 1);
                    new Tomate("tomate_animado.gif", getX() + 40, getY() + 25).iniciarAnimacao();
                } else {
                    System.out.println("acabaram os tomates");
                }
                break;
            case 3:
                if (getDinamites() > 0) {
                    setDinamites(getDinamites() - 1);
                    new Dinamite("bomba_animada.gif", getX() + 40, getY() + 25).iniciarAnimacao();
                } else {
                    System.out.println("acabaram as dinamites");
                }
                break;
        }
        for (ActionListener actionListener : actions) {
            ActionEvent action = new ActionEvent(arma, ActionEvent.ACTION_PERFORMED, null);
            actionListener.actionPerformed(action);
        }
    }
}
