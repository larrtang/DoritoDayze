/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author lxtang
 */
public class Character {
    public float health;
    public float mana;
    
    public float maxHealth;
    public float maxMana;
    public float maxDefense;
    
    public float attack;
    public float defense;
    
    public String name;
    
    public boolean alive = true;
    public boolean attacking = false;
    int characterNum;
    int locX;
    int locY;
    
    Image normalImage;
    Image attackImage;
    Image image2;
    Image image3;
    Image image4;
    
    String [] attacks;
    
    public float[] manaNeeded = new float[4];
    
    public Character(){
        attacks = new String[4];
    }
    
    public void draw(int x, int y, Graphics g, JFrame f){
        if (this.health <= 0){
            this.alive = false;
        }
        else if(this.alive){
        if (attacking){
            g.drawImage(this.attackImage, x,y,f);
        }
        else{
            g.drawImage(this.normalImage, x,y,f);
        }
        }
    }
    public void basic_attackCharacter(Character c){
        c.health -= this.attack * c.defense;
    }
    
    public Image changeImage(Image image){
        Image ret = this.normalImage;
        this.normalImage = image;
        return ret;
    }

}
