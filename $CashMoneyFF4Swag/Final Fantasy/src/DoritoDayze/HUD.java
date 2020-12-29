/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.text.AttributedCharacterIterator;
import javax.swing.*;

/**
 *
 * @author lxtang
 */
public class HUD {
    
    private Image cursor;
    private int cursorLocY [] = new int[4];
    private final int healthBarWidth = 200; 
    private final int manaBarWidth = 100;
   
    
    public HUD( Image cursor){
        this();
        this.cursor = cursor;
    }
    
    public HUD(){
        for (int i = 0; i < 4; i++){
            cursorLocY[i] = 630 + i*40;
        }
    }
    
    public void drawHUD(Character c, Graphics g,JFrame f, int currentAbilitySelected){
        g.setColor(new Color(0,0,150));
        g.fill3DRect(0, 600, 1280, 200, true);
        g.setColor(Color.white);
        
        for (int i = 0; i < c.attacks.length; i++){
            
            g.drawString(c.attacks[i] + "   -" + c.manaNeeded[i] +"MP", 100, 630 + i*40);
            //JLabel l = new JLabel(c.attacks[i]);
            //l.setLocation(100, 630 + i*20);
            //f.add(l);
        }
        
        g.drawImage(cursor, 60, cursorLocY[currentAbilitySelected] - 20, f);
        
        
    }
    
    public void drawHealth(LT lt, KJ kj, CN cn, MH mh,Graphics g){
        g.setColor(Color.white);
        
        g.drawString("Larry Tang", 600, 610);
        g.drawString("Kyle Jensen", 600, 640);
        g.drawString("Caleb Nash", 600, 670);
        g.drawString("Mr. Hayes", 600, 700);
        
        g.setColor(Color.black);
        
        g.fillRect(640,610, healthBarWidth + 4, 20);
        g.fillRect(640,640, healthBarWidth+ 4, 20);
        g.fillRect(640,670, healthBarWidth+ 4, 20);
        g.fillRect(640,700, healthBarWidth+ 4, 20);
        
        g.fillRect(860, 610, manaBarWidth+ 4, 20);
        g.fillRect(860, 640, manaBarWidth+ 4, 20);
        g.fillRect(860, 670, manaBarWidth+ 4, 20);
        g.fillRect(860, 700, manaBarWidth+ 4, 20);
        
        g.setColor(Color.green);
        g.fillRect(642, 612,(int)Math.round((lt.health/lt.maxHealth) * healthBarWidth), 16);
        g.fillRect(642, 642,(int)Math.round((kj.health/kj.maxHealth) * healthBarWidth), 16);
        g.fillRect(642, 672,(int)Math.round((cn.health/cn.maxHealth) * healthBarWidth), 16);
        g.fillRect(642, 702,(int)Math.round((mh.health/mh.maxHealth) * healthBarWidth), 16);
        
        g.setColor(Color.blue);
        g.fillRect(862, 612,(int)Math.round((lt.mana/lt.maxMana) * manaBarWidth), 16);
        g.fillRect(862, 642,(int)Math.round((kj.mana/kj.maxMana) * manaBarWidth), 16);
        g.fillRect(862, 672,(int)Math.round((cn.mana/cn.maxMana) * manaBarWidth), 16);
        g.fillRect(862, 702,(int)Math.round((mh.mana/mh.maxMana) * manaBarWidth), 16);
    }
}
