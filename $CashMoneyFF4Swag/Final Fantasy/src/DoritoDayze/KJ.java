/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;
import javax.swing.ImageIcon;
/**
 *
 * @author lxtang
 */
public class KJ extends Character{
    
    
    public KJ(){
        this.health = 150;
        this.mana = 40;
        
        this.attack = 50;
        this.defense = 0.9f;
        
        this.name ="KJ";
        String sattacks [] = {"Basic Attack","Thor Smash","Spread Eagle","Odins Fury"};
        this.attacks = sattacks;
        
        float mn [] = {0,10,15,20};
        this.manaNeeded = mn;
        
        this.normalImage = new ImageIcon("CharacterPics/kYLEnEW.png").getImage();
        this.attackImage = new ImageIcon("CharacterPics/Kyle Battle/KyleGuyRagin.png").getImage();
        this.image2 = new ImageIcon("CharacterPics/Kyle Battle/KyleGuyRaginThoSMASH.png").getImage();
        this.image3 = new ImageIcon("CharacterPics/Kyle Battle/KyleGuyRagin.png").getImage();
        this.image4 = new ImageIcon("CharacterPics/Kyle Battle/KyleGuyRaginOdinsFury.png").getImage();


        this.maxHealth = health;
        this.maxMana = mana;
        this.maxDefense = defense;
    }
    public void thor_smash_attackCharacter(Character c){
        if (this.mana >= 10){
            c.health -= (this.attack*1.20) * c.defense;
            this.mana -= 10;
        }
        else{
            
        }
    }
    
    public void spread_eagle_attackCharacter(Character c){
        if (this.mana >= 15){
            c.health -= (this.attack*1.60) * c.defense;
            this.mana -= 15;
        }
        else{
            
        }
    }
    public void odins_fury_attackCharacter(Character c){
        if (this.mana >= 30){
            c.health -= (this.attack*2.4) * c.defense;
            this.mana -= 30;
        }
        else{
            
        }
    }
}
