/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DoritoDayze;

/**
 *
 */ 
//@author Scot
import java.awt.Component;
import java.awt.HeadlessException;
import java.io.*;
import javax.swing.*;
import sun.audio.*;

public class Sound {
    public Sound(){
        try{
            //JFileChooser openfile = new JFileChooser();
            //Component j = null;
            //openfile.showOpenDialog(j);
            //File fl = openfile.getSelectedFile();
            //String str = fl.getAbsolutePath();
            InputStream input = new FileInputStream("Final_Fantasy_X_Soundtrack_Seymour_Battle_Theme.wav");
            AudioStream audios = new AudioStream(input);
           AudioPlayer.player.start(audios);
           if (!AudioPlayer.player.isAlive()){
              AudioPlayer.player.start(audios); 
           }

            
        }catch(Exception e){}
    }
    public boolean IsAlive(){
        return AudioPlayer.player.isAlive();
    }
}
 