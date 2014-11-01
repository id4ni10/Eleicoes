/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import eleicoes2014.ImagemItem;
import engine.core.GameController;
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
            Aliado i = (Aliado) GameController.getInstance().getColisaoItem(Aliado.class, this);

            if (i != null) {
                GameController.getInstance().setFimJogo(true);//Informa o fim do jogo
                GameController.getInstance().addItem(new ImagemItem("game-over.jpg", 150, 150));
                i.setVisible(false);//Apaga a nave
            }
        }
        setVisible(false);
        morri();
    }

    protected abstract void morri();
}
