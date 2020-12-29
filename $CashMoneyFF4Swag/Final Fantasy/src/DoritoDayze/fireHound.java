/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;
import javax.swing.*;
/**
 *
 * @author larrytang
 */
public class fireHound extends Enemy{
    public fireHound(){
        
        this.attack = 20;
        this.health = 100;
        this.defense = 1;
        this.maxHealth = health;
        
        this.normalImage = new ImageIcon("EnemyPics/Firey Hound.png").getImage();
        
    }
}
