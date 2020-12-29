/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author lxtang
 */
public class LT extends Character{
    
    
   
    public LT() {
       
        super(); 
        this.health = 100;
        this.mana = 50;
        
        this.attack = 45;
        this.defense = 0.9f;
        
        this.name ="LT";
        float mn [] = {0,10,15,20};
        this.manaNeeded = mn;
        
        String LTattacks [] = {"Basic Attack","Round House","Nunchaku","Lightning Nunchaku"};
        super.attacks = LTattacks;
       
        
        
        this.normalImage = new ImageIcon("CharacterPics/LarryGuyFacingLeft.png").getImage();
        this.attackImage = new ImageIcon("CharacterPics/LarryGuyYelling.png").getImage();
        this.image2 = new ImageIcon("CharacterPics/Larry Battle/LarryGuyYelling.png").getImage();
        this.image3 = new ImageIcon("CharacterPics/Larry Battle/LarryGuyYellingNunchucks.png").getImage();
        this.image4 = new ImageIcon("CharacterPics/Larry Battle/LarryGuyYellingNunchucksUpLightning.png").getImage();
        
        this.maxHealth = health;
        this.maxMana = mana;
        this.maxDefense = defense;
    }
    public void basic_attackCharacter(Character c){
        c.health -= this.attack * c.defense;
    }
    //    public float basic_attackCharacter(Character c){
//        float ret = c.health - this.attack * c.defense;
//        return ret;
//    }
    public void roundHouse_attackCharacter(Character c){
        if (this.mana >= 10){
            c.health -= (this.attack*1.75) * c.defense;
            this.mana -= 10;
        }
        else{
            
        }
    }
    
    public void nunchaku_attackCharacter(Character c){
        if (this.mana >= 15){
            c.health -= (this.attack*2.125) * c.defense;
            this.mana -= 15;
        }
        else{
            
        }
    }
    public void lightning_nunchaku_attackCharacter(Character c){
        if (this.mana >= 20){
            c.health -= (this.attack*2.725) * c.defense;
            this.mana -= 20;
        }
        else{
            
        }
    }
}
