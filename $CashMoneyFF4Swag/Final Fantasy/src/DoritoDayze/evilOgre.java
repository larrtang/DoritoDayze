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
public class evilOgre extends Enemy{
    public evilOgre(){
        this.health = 200;
        this.attack = 25;
        this.defense = 0.8f;
        this.maxHealth = health;
        
        this.normalImage = new ImageIcon("EnemyPics/EvilOgre.png").getImage();
    }
}
