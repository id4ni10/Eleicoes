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
public abstract class Inimigo extends Item {

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private int HP;
    private String nome;

    public Inimigo(String img, int x, int y) {
        super(img, x, y);
    }

    @Override
    public void animar() {
        while (getHP() > 0) {
            left();
            //changeImagem("2");
            pausar(100);
            //changeImagem("DEFAULT");            
        }
        setVisible(false);
        this.morri();
    }

    protected abstract void morri();
}
