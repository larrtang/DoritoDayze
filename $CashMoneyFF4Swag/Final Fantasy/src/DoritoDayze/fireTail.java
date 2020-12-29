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
public class fireTail extends Enemy{
    public fireTail(){
        this.health = 150;
        this.attack = 35;
        this.defense = 0.8f;
                this.maxHealth = health;

            this.normalImage = new ImageIcon("EnemyPics/FireTailFinal.png").getImage();
    }
}
