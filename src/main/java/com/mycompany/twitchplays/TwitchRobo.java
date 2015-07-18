/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;

/**
 *
 * @author john
 */
public class TwitchRobo extends PircBot {
    private final Credentials cred = new Credentials();
    
    private Map<String, Integer> input = new HashMap<String, Integer>();
    
    private final Robot robo;
    
    /**
     * 
     */
    public TwitchRobo() throws AWTException {
       
        this.robo = new Robot();
     
        this.setName(cred.getUsername());
        input.put("start", KeyEvent.VK_ENTER);
        input.put("up", KeyEvent.VK_G);
        input.put("down", KeyEvent.VK_H);
        input.put("left", KeyEvent.VK_L);
        input.put("right", KeyEvent.VK_R);
        input.put("a", KeyEvent.VK_X);
        input.put("b", KeyEvent.VK_C);
        input.put("l", KeyEvent.VK_A);
        input.put("r", KeyEvent.VK_S);
        input.put("z", KeyEvent.VK_Z);
        input.put("cup", KeyEvent.VK_Q);
        input.put("cdown", KeyEvent.VK_W);
        input.put("cleft", KeyEvent.VK_E);
        input.put("cright", KeyEvent.VK_T);
        
    }
    /**
     * onMessage is a listener method that allows the user to check the irc chat
     * and grab items from the parameter variables.
     * @param channel
     * @param sender
     * @param login
     * @param hostname
     * @param message 
     */
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message){
         
            if(input.get(message) != null)
            {
                try{
                    //create a new robot to place in inputs
                    Robot robo = new Robot();
                    robo.keyPress(input.get(message));
                    robo.delay(750);
                    robo.keyRelease(input.get(message));
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            } 
        }
    
    @Override
    public void onDisconnect(){
        //if it ever disconnects reconnect
        while(!this.isConnected()){    
        try {
                this.connect("irc.twitch.tv", 6667, cred.getToken());
                this.joinChannel(cred.getChannel());                
            }catch (IOException ex) {
                Logger.getLogger(TwitchRobo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IrcException ex) {
                Logger.getLogger(TwitchRobo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setUp(){
        
        Random rand = new Random();
        
        //Try to get to free play
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_ENTER);
        robo.delay(2000);
        robo.keyPress(KeyEvent.VK_X);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_X);
        robo.delay(2000);
        robo.keyPress(KeyEvent.VK_X);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_X);
        robo.delay(2000);
        robo.keyPress(KeyEvent.VK_H);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_H);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_R);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_R);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_R);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_R);
        
        for(int i = 0; i < 7; ++i){
        robo.keyPress(KeyEvent.VK_X);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_X);
        robo.delay(1000);
        }

        //pokemon Selection
        robo.keyPress(KeyEvent.VK_H);
        robo.delay(rand.nextInt(1000));
        robo.keyRelease(KeyEvent.VK_H);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_X);
         robo.delay(800);
         robo.keyRelease(KeyEvent.VK_X);
         robo.delay(800);
         robo.keyPress(KeyEvent.VK_X);
         robo.delay(800);
         robo.keyRelease(KeyEvent.VK_X);
         robo.delay(800);
        
        robo.keyPress(KeyEvent.VK_K);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_K);
        robo.delay(1000);
        
        robo.keyPress(KeyEvent.VK_V);
        robo.delay(rand.nextInt(1000));
        robo.keyRelease(KeyEvent.VK_V);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_K);
         robo.delay(1000);
         robo.keyRelease(KeyEvent.VK_K);
         robo.delay(1000);
         robo.keyPress(KeyEvent.VK_K);
         robo.delay(1000);
         robo.keyRelease(KeyEvent.VK_K);
         robo.delay(1000);
    }

     
    
    
}
