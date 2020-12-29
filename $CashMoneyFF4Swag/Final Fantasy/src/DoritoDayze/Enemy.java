/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author kejensen
 */
public class Enemy extends Character{
    Random r = new Random();
    
    public  double maxHealth; 
    int characterToAttack;
    public Enemy(){
        //this.health = 1000;
        //this.defense = 1;
        
        //this.attack = 200;
        //this.normalImage = new ImageIcon("CharacterPics/KyleGuyFacingLeft.png").getImage();
        //this.attackImage = new ImageIcon("CharacterPics/KyleGuyYelling.png").getImage();
        
        
    }
    
    public void draw(int x,int y,Graphics g, JFrame f){
        
        if (this.health <= 0){
            this.alive = false;
        }
        else if (this.alive){
        super.draw(x, y, g, f);
        final int healthBarWidth = 100;
        
        g.setColor(Color.black);
        g.fillRect(x,y-10, healthBarWidth + 2, 16);
        
        g.setColor(Color.green);
        g.fillRect(x+1,y-9, (int)((this.health/this.maxHealth)*healthBarWidth), 14);
        }
    }
    
    public void basic_attackCharacter(ArrayList<Character> characters){
        
        this.characterToAttack = r.nextInt(characters.size());
        characters.get(characterToAttack).health -= this.attack * characters.get(characterToAttack).defense;
        if (characters.get(characterToAttack).health <= 0){
            characters.get(characterToAttack).health = 0;
        }
        //System.out.println("YOLOOOO");
    }
   
    
            
    
}
