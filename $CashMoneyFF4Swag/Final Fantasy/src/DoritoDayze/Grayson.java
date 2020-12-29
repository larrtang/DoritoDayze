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
public class Grayson extends Enemy{
    
    public Grayson(){
        this.health = 1200;
        this.attack = 40;
        this.defense = 0.7f;
        
        this.maxHealth = health;
        
        this.normalImage = new ImageIcon("EnemyPics/Grayson.png").getImage();
    }
}
