/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.core.GameController;
import engine.itens.Item;

/**
 *
 * @author Danilo
 */
public class Estudante extends Aliado {
    
    public Estudante(String img) {
        super(img);
        setX(100);
        setY(320);
        setDeslocamento(5);
    }
    
    @Override
    public void animar() {
        Item i = GameController.getInstance().getColisaoItem(Tomate.class, this);
        if (i != null) {
            setTomates(getTomates() + 1);
        }
    }
    
    public static Estudante criar(int tipoEstudante){
        if(tipoEstudante == 1){
            return new Estudante("personagens/Personagem1.gif");
        } else if(tipoEstudante == 2){
            return new Estudante("personagens/Personagem2.gif");
        } else {
            return new Estudante("personagens/Personagem3.gif");
        }
    }

}
