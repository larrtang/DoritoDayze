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
public class deathPuppet extends Enemy{
    public deathPuppet(){
        this.health = 100;
        this.attack = 65;
        this.defense = 1.1f;
                this.maxHealth = health;

        this.normalImage = new ImageIcon("EnemyPics/FkinDeathPuppet.png").getImage();

                
    }
}
