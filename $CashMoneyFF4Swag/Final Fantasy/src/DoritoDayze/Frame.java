/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.Timer;
/**
 *
 * @author lxtang
 */
public class Frame extends JFrame implements ActionListener{
    
    boolean won = false;
    boolean lost = false;
        
    int start_gameLocX = 800;
    int start_gameLocY = 270;
    int exit_gameLocX = 800;
    int exit_gameLocY = 380;
    
    int cursorLocX;
    int cursorLocY;

    int titleOption = 1;
    int gameMode = 0; //0 - title 1 - sandbox 2 - battle 
    
    int characterLocX [] = {770,770,770,770};
    int characterLocY [] = {20,180,340,480};
    
    int enemyLocX [] = {10,10,10,10};
    int enemyLocY [] = {20,180,340,480};

    int characterSelected = 0; 
    int currentCharacterSelected;
    int enemySelected = 0;
    
    int enemyAttacking = 0;
    int currentEnemyAttacking;
    
    int currentAbilitySelected = 0;
    
    int Level = 1;
    
    int timerInterval = 10;
    Timer timer = new Timer(timerInterval,this);
    
    
    boolean repeatAbility = false;
    boolean isAttacking = false;
    
    
    int steps = 20;
    int countSteps = 0;
    boolean movingBack = false;
    boolean isEnemyAttacking = false;
    
    
    Image oldImage = null;
    Image titleImage = new ImageIcon("DoritoDayzeStartup.png").getImage();
    Image cursor = new ImageIcon("HandCursor.png").getImage();
    Image battleBackground1 = new ImageIcon("Backgrounds/SwampyBackground1.png").getImage();
    
    
    LT lt = new LT();
    KJ kj = new KJ();
    CN cn = new CN();
    MH mh = new MH();
    
    fireHound fh1 = new fireHound();
    fireHound fh2 = new fireHound();
    evilOgre eo1 = new evilOgre();
    
    deathPuppet dp = new deathPuppet();
    giantTurtle gt = new giantTurtle();
    fireTail ft = new fireTail();
    
    Grayson gray = new Grayson();
    

    HUD hud = new HUD(cursor);
    //boolean isSelectingCharacter = false;
    boolean isSelectingAbility = true;
    boolean isSelectingEnemy = false;   
    
    Graphics buffer;
    Image backScreen;
    
    public ArrayList<Character> Characters = new ArrayList();
    
    public ArrayList<Enemy> Enemies = new ArrayList();
    
    public ArrayList<Enemy> Enemies1 = new ArrayList();
    public ArrayList<Enemy> Enemies2 = new ArrayList();
    public ArrayList<Enemy> Enemies3 = new ArrayList();
    
    
    public Frame(){
        this.setSize(1280,800);
        this.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.getContentPane().setBackground(Color.white);
        
        Sound s = new Sound();
        
        Characters.add(lt);
        Characters.add(kj);
        Characters.add(cn);
        Characters.add(mh);
        
       
        Enemies2.add(gt);
        Enemies2.add(dp);
        Enemies2.add(ft);
        
        
        Enemies1.add(fh1);
        Enemies1.add(fh2);
        Enemies1.add(eo1);
        
        
        Enemies3.add(gray);
        Enemies = Enemies1;
        
        
                    

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        
        this.cursorLocX = start_gameLocX;
        this.cursorLocY = start_gameLocY;
        
        //System.out.println(this.Characters.get(1).getClass().getName());
    }
    
   
    
    public void formKeyPressed(KeyEvent e){
         if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
               System.exit(0);
           }
        repaint();
       if(gameMode == 0){
          
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
               if (titleOption == 1){
                   gameMode = 1;
                   repaint();
                   
               }
               else if (titleOption == -1){
                   System.exit(0);
               }
           }
           else if ((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_DOWN)){
               if (cursorLocY == start_gameLocY){
                    cursorLocY = exit_gameLocY;
                    titleOption = -1;
                    repaint();
                    //System.out.println(cursorLocY);
               }
               else if (cursorLocY == exit_gameLocY){
                    cursorLocY = start_gameLocY;
                    titleOption = 1;
                    repaint();
                    //System.out.println(cursorLocY);
               }
              
            }
            
        }
       
       else if(gameMode == 1){
           if (!timer.isRunning()){
               if(this.isSelectingAbility){
                   this.selectAbility(e);
                   this.enemySelected = 0;
               }

               else if (this.isSelectingEnemy){
                   this.selectEnemy(e);
                   //this.currentAbilitySelected =0;
               }
           }
           
       }
   }
//    public void paint(Graphics g){
//       
//        
//        if (gameMode == 0){
//            g.drawImage(titleImage, -100, -20, this);
//            g.drawImage(cursor, cursorLocX, cursorLocY,this);
//        }
//        
//        else if (gameMode == 1){
//           
//                
//            
//            
//            g.drawImage(battleBackground1,0,0,this);
//           
//            
//            
//            if (this.Level ==  1){
//                Enemies = Enemies1;
//            }
//            else if (this.Level ==  2){
//               Enemies = Enemies2;
//               this.battleBackground1 = new ImageIcon("Backgrounds/AltarInsideVolcoBackground2.png").getImage();
//            }
//            
//            else if (this.Level ==  3){
//                 Enemies = Enemies3;
//                 this.battleBackground1 = new ImageIcon("Backgrounds/FinalDestinationBackground2.png").getImage();
//                
//            }
//         
//            g.drawImage(cursor, this.characterLocX[this.characterSelected] - 20, this.characterLocY[this.characterSelected] + 30, this);
//            
//            if (this.isSelectingEnemy){
//                g.drawImage(cursor, this.enemyLocX[this.enemySelected]-20,  this.enemyLocY[this.enemySelected] + 30, this);
//                System.err.println(this.enemySelected);
//            }
//           
//            hud.drawHUD(this.Characters.get(this.characterSelected), g,this,this.currentAbilitySelected);
//            hud.drawHealth(lt, kj, cn, mh, g);
//           
//            //this.buffer = backScreen.getGraphics();
//            
//            drawEnemies(g);
//            drawCharacters(g);
//        }
//        else if(gameMode == 4){
//            lost = true;
//        }
//            
//        
//            
//        
//        Graphics gg = g;  
//        Win(won,gg);
//        Lose(lost,gg);
//    }
    
    @Override
    public void paint(Graphics g){
       this.backScreen = createImage(1280,800);
       this.buffer = this.backScreen.getGraphics();
        
        if (gameMode == 0){
            g.drawImage(titleImage, -100, -20, this);
            g.drawImage(cursor, cursorLocX, cursorLocY,this);
        }
        
        else if (gameMode == 1){
           
                
                
            
            buffer.drawImage(battleBackground1,0,0,this);
           
            
            
            if (this.Level ==  1){
                Enemies = Enemies1;
            }
            else if (this.Level ==  2){
               Enemies = Enemies2;
               this.battleBackground1 = new ImageIcon("Backgrounds/AltarInsideVolcoBackground2.png").getImage();
            }
            
            else if (this.Level ==  3){
                 Enemies = Enemies3;
                 this.battleBackground1 = new ImageIcon("Backgrounds/FinalDestinationBackground2.png").getImage();
                
            }
         
            buffer.drawImage(cursor, this.characterLocX[this.characterSelected] - 20, this.characterLocY[this.characterSelected] + 30, this);
            
            if (this.isSelectingEnemy){
                buffer.drawImage(cursor, this.enemyLocX[this.enemySelected]-20,  this.enemyLocY[this.enemySelected] + 30, this);
                System.err.println(this.enemySelected);
            }
           
            hud.drawHUD(this.Characters.get(this.characterSelected), buffer,this,this.currentAbilitySelected);
            hud.drawHealth(lt, kj, cn, mh, buffer);
           
            //this.buffer = backScreen.getGraphics();
            
            if (this.isAttacking){
                drawEnemies(buffer);
               g.drawImage(backScreen, 0, 0, this);
               drawCharacters(g);
            }
            if (this.isEnemyAttacking){
                drawCharacters(buffer);
               g.drawImage(backScreen, 0, 0, this);
               drawEnemies(g);
            }
            else{
                g.drawImage(backScreen, 0, 0, this);
                drawEnemies(g);
                drawCharacters(g);
            }
            
           
        }
        else if(gameMode == 4){
            lost = true;
        }
            
        
            
        
        Graphics gg = g;  
        Win(won,gg);
        Lose(lost,gg);
    }
    @Override
    public void update(Graphics g){
        paint(g);
    }
    public void selectAbility(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP){
                   if (this.currentAbilitySelected <= 0){
                       this.currentAbilitySelected = 3;
                   }
                   else{
                       this.currentAbilitySelected --;
                   }
                   repaint();

               }
               else if (e.getKeyCode() == KeyEvent.VK_DOWN){
                   if (this.currentAbilitySelected >= 3){
                       this.currentAbilitySelected = 0;
                   }
                   else{
                       this.currentAbilitySelected ++;
                   }
                   repaint();
               }
               
               else if (e.getKeyCode() == KeyEvent.VK_ENTER){
                   if (this.Characters.get(this.characterSelected).mana >= this.Characters.get(this.characterSelected).manaNeeded[this.currentAbilitySelected]){
                       this.isSelectingAbility = false;
                  
                        this.isSelectingEnemy = true;
                   }
                  
                   repaint();
               }
        
               repaint();
               this.enemySelected = 0;
           }
    public void selectEnemy(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP){
                   if (this.enemySelected <= 0){
                       this.enemySelected = Enemies.size()-1;
                   }
                   else{
                       this.enemySelected --;
                   }
                   repaint();

               }
               else if (e.getKeyCode() == KeyEvent.VK_DOWN){
                   if (this.enemySelected >= Enemies.size()-1){
                       this.enemySelected = 0;
                   }
                   else{
                       this.enemySelected ++;
                   }
                   repaint();
                   
            
               }
               
               if (e.getKeyCode() == KeyEvent.VK_ENTER){
                   isAttacking = true;
                   currentCharacterSelected = this.characterSelected;
                   currentEnemyAttacking = this.enemyAttacking;
                   System.out.println("CCS" + this.currentCharacterSelected);
                   
                   oldImage = this.Characters.get(currentCharacterSelected).normalImage;
                    
                    timer.start();
                    
                    
                   if (this.Characters.get(this.characterSelected).name.equals("LT")){
                       if (this.currentAbilitySelected == 0){
                           //this.Enemies.get(this.enemySelected).health = lt.basic_attackCharacter(this.Enemies.get(this.enemySelected));
                           lt.basic_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 1){
                           lt.roundHouse_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 2){
                           lt.nunchaku_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 3){
                           lt.lightning_nunchaku_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                   }
                   else if (this.Characters.get(this.characterSelected).name.equals("KJ")){
                       if (this.currentAbilitySelected == 0){
                           //this.Enemies.get(this.enemySelected).health = lt.basic_attackCharacter(this.Enemies.get(this.enemySelected));
                           kj.basic_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 1){
                           kj.thor_smash_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 2){
                           kj.spread_eagle_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 3){
                           kj.odins_fury_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                   }
                   else if (this.Characters.get(this.characterSelected).name.equals("CN")){
                       if (this.currentAbilitySelected == 0){
                           //this.Enemies.get(this.enemySelected).health = lt.basic_attackCharacter(this.Enemies.get(this.enemySelected));
                           cn.basic_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 1){
                           cn.heal_supportCharacter(this.Characters);
                           System.out.println(this.currentAbilitySelected);
                           
                       }
                       else if (this.currentAbilitySelected == 2){
                           cn.spirit_bomb_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 3){
                           cn.TTTT_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                   }
                   else if (this.Characters.get(this.characterSelected).name.equals("MH")){
                       if (this.currentAbilitySelected == 0){
                           //this.Enemies.get(this.enemySelected).health = lt.basic_attackCharacter(this.Enemies.get(this.enemySelected));
                           mh.basic_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 1){
                           mh.dorrito_shurikan_attackCharacter(this.Enemies.get(this.enemySelected));
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 2){
                           mh.dorrito_shield_defenseCharacter();
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                       else if (this.currentAbilitySelected == 3){
                           mh.dorrito_dayze_defenseattacktauntCharacter(this.Enemies.get(this.enemySelected),lt,kj,cn);
                           System.out.println(Enemies.get(this.enemySelected).health);
                       }
                   }
                   repaint();
                   
                   if (this.characterSelected >= this.Characters.size()-1){
                       
                       
                       isEnemyAttacking = true;                       
                                     

                       
                       for (int i = 0; i < Enemies.size(); i++){
                            Enemies.get(i).basic_attackCharacter(Characters);
                            
                            
                       } 
                       

                       
                       
                       
                       repaint();
                       
                       this.characterSelected = 0;
                       
                   }
                   else{
                       this.characterSelected ++;
                   }
                   this.isSelectingEnemy = false;
                   this.isSelectingAbility = true;
               }
                                 

               
    }
    
    public void characterAttackAnimation(int cs) {
        
        int moveX = (int)(Math.round((this.characterLocX[cs] - this.enemyLocX[this.enemySelected])/(steps)));
        int moveY = (int)(Math.round((this.characterLocY[cs] - this.enemyLocY[this.enemySelected])/(steps)));
        
        
        if ((countSteps < steps) && movingBack == false){
            if (this.currentAbilitySelected == 0){
                this.Characters.get(cs).changeImage(this.Characters.get(cs).attackImage);
            }
            else if (this.currentAbilitySelected == 1){
                this.Characters.get(cs).changeImage(this.Characters.get(cs).image2);
            }
            else if (this.currentAbilitySelected == 2){
                this.Characters.get(cs).changeImage(this.Characters.get(cs).image3);
            }
            else if (this.currentAbilitySelected == 3){
                this.Characters.get(cs).changeImage(this.Characters.get(cs).image4);
            }
            
            this.characterLocX[cs] -= moveX;
            this.characterLocY[cs] -= moveY;
            countSteps ++;
            
        }
        else{
            movingBack = true;
            
        }
        
        if(movingBack){
            if (countSteps >= 0){
                this.characterLocX[cs] += moveX;
                this.characterLocY[cs] += moveY;
                countSteps--;
                
            }
            else{
                this.Characters.get(cs).changeImage(oldImage);
            
                movingBack = false;
                isAttacking = false;
                if (this.currentCharacterSelected >= this.Characters.size()-1){
                    timer.restart();
                }
                else{
                        timer.stop(); 
                
                }
                
            }
     
        }
    }
    
    public void enemyAttackAnimation() {
        
        
        int moveX = 0;
        int moveY = 0;
        
        
        moveX = (int)(Math.round((this.characterLocX[this.Enemies.get(this.currentEnemyAttacking).characterToAttack] - this.enemyLocX[this.currentEnemyAttacking])/(steps)));
        moveY = (int)(Math.round((this.characterLocY[this.Enemies.get(this.currentEnemyAttacking).characterToAttack] - this.enemyLocY[this.currentEnemyAttacking])/(steps)));
        
        
        
        if ((countSteps < steps) && movingBack == false){
            this.enemyLocX[this.currentEnemyAttacking] += moveX;
            this.enemyLocY[this.currentEnemyAttacking] += moveY;
            countSteps ++;
            
        }
        else{
            movingBack = true;
        }
        
        if(movingBack){
            if (countSteps >= 0){
                this.enemyLocX[this.currentEnemyAttacking] -= moveX;
                this.enemyLocY[this.currentEnemyAttacking] -= moveY;
                countSteps--;
                
            }
            else{
                movingBack = false;
                
                if (this.currentEnemyAttacking >= this.Enemies.size() - 1){
                    isAttacking = true;
                    isEnemyAttacking = false;
                    timer.stop();
                    currentEnemyAttacking =0;
                    
                    
                }
                else{
                    this.currentEnemyAttacking ++;
                }
                
                
                
            }
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isAttacking){
       characterAttackAnimation(this.currentCharacterSelected);
        }
        else if (isEnemyAttacking){ 
            
            enemyAttackAnimation();
        }
       
        repaint();
    }
    
    public void Win(boolean b, Graphics g){
        if (b){
            g.drawImage(new ImageIcon("Win.png").getImage(), -300, -20, this);
        }
    }
    public void Lose(boolean b, Graphics g){
        if (b){
            g.drawImage(new ImageIcon("Game Over.png").getImage(), -200, -20, this);
        }
    }
    
    
    
    public void drawCharacters(Graphics g){
        
        if (Characters.size() > 0){
                for (int i = 0; i < this.Characters.size(); i++){
                    if (!this.Characters.get(i).alive){
                        repaint();
                        
                        if (!timer.isRunning()){
                            this.Characters.remove(i);
                        }
                        
                       
                    }
                    else{
                        
                        this.Characters.get(i).draw(characterLocX[i], characterLocY[i], g, this);
                    }
                }
            }
            else{
                Level = 0;
                gameMode = 4;
                repaint();
            }
        
    }
    public void drawEnemies(Graphics g){
        if (this.Enemies.size() > 0 && (Level <= 3)){
            for (int i = 0; i < this.Enemies.size(); i++){
                        if (!this.Enemies.get(i).alive){
                             
                             
                             
                             if (!timer.isRunning()){
                                this.Enemies.remove(i);
                             }
                            repaint();
                        }
                        else{
                           this.Enemies.get(i).draw(enemyLocX[i], enemyLocY[i], g, this);
                        }
                    }
            
            }
            else if (Level <= 3){
                
                Level ++;
                           repaint();
                           repaint();
                for (int i = 0; i<this.Characters.size(); i++){
                    this.Characters.get(i).alive = true;
                    this.Characters.get(i).health = this.Characters.get(i).maxHealth;
                    this.Characters.get(i).mana = this.Characters.get(i).maxMana;
                    this.Characters.get(i).defense = this.Characters.get(i).maxDefense;
                }
                  
                
                
                                repaint();

                
                this.currentAbilitySelected = 0;
                this.currentCharacterSelected = 0;
                this.enemySelected = 0;
                this.isSelectingAbility = true;
                this.isSelectingEnemy = false;
                repaint();
            }
            else {
                won = true;
            }
    }
}
