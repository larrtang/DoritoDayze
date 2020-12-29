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
public class MH extends Character{
    
    
    public MH(){
        this.health = 500;
        this.mana = 100;
        
        this.name ="MH";
        
        this.attack = 10;
        this.defense = 0.5f;
        
        String sattacks [] = {"Basic Attack","Dorito Shurikan","Dorito Shield","Dorito Dayze"};
        this.attacks = sattacks;
        
        float mn [] = {0,10,15,100};
        this.manaNeeded = mn;
        
        this.normalImage = new ImageIcon("CharacterPics/MrHayesFacingLeft.png").getImage();
        this.attackImage = new ImageIcon("CharacterPics/MH Battle/MrHayesYELLIN.png").getImage();
        this.image2 = new ImageIcon("CharacterPics/MH Battle/MrHayesDoritoShuriken.png").getImage();
        this.image3 = new ImageIcon("CharacterPics/MH Battle/MrHayesFacingLeftdDoritoShield.png").getImage();
        this.image4 = new ImageIcon("CharacterPics/MH Battle/MrHayesDoritoDayze.png").getImage();

        this.maxHealth = health;
        this.maxMana = mana;
        this.maxDefense = defense;
    }
    
    public void dorrito_shurikan_attackCharacter(Character c){
        if (this.mana >= 10){
            c.health -= (this.attack*1.75) * c.defense;
            this.mana -= 10;
        }
        else{
            
        }
    }
    
    public void dorrito_shield_defenseCharacter(){
        if (this.mana >= 15){
            this.defense -= 0.1;
            this.mana -= 15;
        }
        else{
            
        }
    }
    public void dorrito_dayze_defenseattacktauntCharacter(Character c, LT lt,KJ kj,CN cn ){
        if (this.mana >= 100){
            c.health -= (this.attack*50) * c.defense;
            
            this.defense -= 0.2;
            lt.defense -= 0.2;
            cn.defense -= 0.2;
            kj.defense -= 0.2;
            
            this.mana -= 100;
        }
        else{
            
        }
    }
}