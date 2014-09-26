/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.itens.Item;
import engine.itens.PosicaoRender;

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
        while (true) {
            left();
            pausar(100);
        }
    }
}
