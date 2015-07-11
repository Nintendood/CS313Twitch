/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        input.put("enter", KeyEvent.VK_ENTER);
        input.put("up", KeyEvent.VK_NUMPAD8);
        input.put("down", KeyEvent.VK_NUMPAD2);
        input.put("a", KeyEvent.VK_X);
        input.put("b", KeyEvent.VK_C);
        input.put("left", KeyEvent.VK_NUMPAD4);
        input.put("right", KeyEvent.VK_NUMPAD6);
        input.put("lt", KeyEvent.VK_A);
        input.put("rt", KeyEvent.VK_S);
        input.put("z", KeyEvent.VK_Z);
        input.put("cu", KeyEvent.VK_HOME);
        input.put("cd", KeyEvent.VK_END);
        input.put("cl", KeyEvent.VK_DELETE);
        input.put("cr", KeyEvent.VK_PAGE_DOWN);
        
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
            try {
                reconnect();
                this.connect("irc.twitch.tv", 6667, cred.getToken());
                this.joinChannel(cred.getChannel());                
            }
            catch (Exception e) {
                // Couldn't reconnect!
                // Pause for a short while...?
            }
    }
    
    public void setUp(){
        
        Random rand = new Random();
        Boolean upLeft = true;
        
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
        robo.keyPress(KeyEvent.VK_NUMPAD2);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_NUMPAD2);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_NUMPAD6);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_NUMPAD6);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_NUMPAD6);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_NUMPAD6);
        
        for(int i = 0; i < 8; ++i){
        robo.keyPress(KeyEvent.VK_X);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_X);
        robo.delay(1000);
        }
        
        //pokemon Selection
        for(int i = 0; i < 3; ++i){
        System.out.println(" up left this is being called " + i);
        robo.keyPress(KeyEvent.VK_NUMPAD2);
        robo.delay(rand.nextInt(8080));
        robo.keyRelease(KeyEvent.VK_NUMPAD2);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_NUMPAD6);
        robo.delay(rand.nextInt(900));
        robo.keyRelease(KeyEvent.VK_NUMPAD6);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_X);
         robo.delay(800);
         robo.keyRelease(KeyEvent.VK_X);
         robo.delay(800);
         robo.keyPress(KeyEvent.VK_X);
         robo.delay(800);
         robo.keyRelease(KeyEvent.VK_X);
         robo.delay(800);
        System.out.println("this is being called " + i);
        robo.keyPress(KeyEvent.VK_NUMPAD8);
        robo.delay(rand.nextInt(8080));
        robo.keyRelease(KeyEvent.VK_NUMPAD8);
        robo.delay(800);
        robo.keyPress(KeyEvent.VK_NUMPAD6);
        robo.delay(rand.nextInt(900));
        robo.keyRelease(KeyEvent.VK_NUMPAD6);
        robo.delay(800);
        robo.keyPress(KeyEvent.VK_X);
        robo.delay(800);
        robo.keyRelease(KeyEvent.VK_X);
        robo.delay(800);
        robo.keyPress(KeyEvent.VK_X);
        robo.delay(800);
        robo.keyRelease(KeyEvent.VK_X);
        robo.delay(800);
        }
       
        
        //finish the automation and start the battle
        for(int i = 0; i < 2; ++i) {
       robo.keyPress(KeyEvent.VK_X);
       robo.delay(1000);
       robo.keyRelease(KeyEvent.VK_X);
       robo.delay(1000);
        }
        
        for(int i = 0; i < 3; ++i){
        System.out.println(" up left this is being called " + i);
        robo.keyPress(KeyEvent.VK_NUMPAD2);
        robo.delay(rand.nextInt(8080));
        robo.keyRelease(KeyEvent.VK_NUMPAD2);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_NUMPAD6);
        robo.delay(rand.nextInt(800));
        robo.keyRelease(KeyEvent.VK_NUMPAD6);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_X);
         robo.delay(1000);
         robo.keyRelease(KeyEvent.VK_X);
         robo.delay(1000);
         robo.keyPress(KeyEvent.VK_X);
         robo.delay(1000);
         robo.keyRelease(KeyEvent.VK_X);
         robo.delay(1000);
        System.out.println("this is being called " + i);
        robo.keyPress(KeyEvent.VK_NUMPAD8);
        robo.delay(rand.nextInt(8080));
        robo.keyRelease(KeyEvent.VK_NUMPAD8);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_NUMPAD6);
        robo.delay(rand.nextInt(800));
        robo.keyRelease(KeyEvent.VK_NUMPAD6);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_X);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_X);
        robo.delay(1000);
        robo.keyPress(KeyEvent.VK_X);
        robo.delay(1000);
        robo.keyRelease(KeyEvent.VK_X);
        robo.delay(1000);
        }

          for(int i = 0; i < 2; ++i) {
       robo.keyPress(KeyEvent.VK_X);
       robo.delay(1000);
       robo.keyRelease(KeyEvent.VK_X);
       robo.delay(1000);
        }
    }
    
}
