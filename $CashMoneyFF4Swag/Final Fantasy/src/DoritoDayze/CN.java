/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author lxtang
 */
public class CN extends Character{
    
    public CN(){
        this.health = 75;
        this.mana = 131;
        
        this.name ="CN";
        String sattacks [] = {"Basic Attack","Heal","Spirit Bomb","TTTT"};
        this.attacks = sattacks;
        
        this.attack = 15;
        this.defense = 0.95f;
        
        float mn [] = {-200,10,20,40};
        this.manaNeeded = mn;
        
        this.normalImage = new ImageIcon("CharacterPics/MeGuyFacinLeft.png").getImage();
        this.attackImage = new ImageIcon("CharacterPics/MeGuyFacinLeft.png").getImage();
        this.image2 = new ImageIcon("CharacterPics/Caleb Battle/MeGuyFacinLeftHealin.png").getImage();
        this.image3 = new ImageIcon("CharacterPics/Caleb Battle/MeGuyFacingLeftSpiritBombS1.png").getImage();
        this.image4 = new ImageIcon("CharacterPics/Caleb Battle/MeGuyFacingLeftSpiritBombS3.png").getImage();

        
        this.maxHealth = health;
        this.maxMana = mana;
        this.maxDefense = defense;
    }
    
    public void heal_supportCharacter(ArrayList<Character> c){
        if (this.mana >= 10){
            for (Character ch : c){
                if (ch.health + 30 >= ch.maxHealth){
                    ch.health = ch.maxHealth;
                }
                else{
                    ch.health += 30;
                }
                this.mana -= 10;
            }
        }
        else{
            
        }
    }
    
    public void spirit_bomb_attackCharacter(Character c){
        if (this.mana >= 20){
            c.health -= (this.attack*4.0) * c.defense;
            this.mana -= 20;
        }
        else{
            
        }
    }
    public void TTTT_attackCharacter(Character c){
        if (this.mana >= 40){
            c.health -= (this.attack*6.0) * c.defense;
            this.mana -= 40;
        }
        else{
            
        }
    }
}
