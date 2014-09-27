/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.itens.Item;

/**
 *
 * @author Danilo
 */
public abstract class Aliado extends Item {

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
    }

    public Aliado(String img) {
        super(img);
    }

    public void atirar(int arma) {
        switch (arma) {
            case 1:
                if (getBolasDePapel() > 0) {
                    setBolasDePapel(getBolasDePapel() - 1);
                    new BolaDePapel("bala.jpg", getX() + 24, getY() - 50).iniciarAnimacao();
                } else {
                    System.out.println("acabaram os papeis");
                }
                break;
            case 2:
                if (getTomates() > 0) {
                    setTomates(getTomates() - 1);
                    new Tomate("tomate.png", getX() + 24, getY() - 50).iniciarAnimacao();
                } else {
                    System.out.println("acabaram os tomates");
                }
                break;
            case 3:
                if (getDinamites() > 0) {
                    setDinamites(getDinamites() - 1);
                    new Dinamite("bomba_anim.gif", getX() + 24, getY() - 50).iniciarAnimacao();
                } else {
                    System.out.println("acabaram as dinamites");
                }
                break;
        }
    }
}
