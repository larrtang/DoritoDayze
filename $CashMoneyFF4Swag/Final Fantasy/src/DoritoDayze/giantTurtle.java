/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;

import javax.swing.ImageIcon;

/**
 *
 * @author larrytang
 */
public class giantTurtle extends Enemy{
    public giantTurtle(){
        this.health = 350;
        this.attack = 25;
        this.defense = 0.7f;
                this.maxHealth = health;

        this.normalImage = new ImageIcon("EnemyPics/Giant Turtle.png").getImage();

    }
}
