/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;

/**
 *
 * @author Adam
 */
public class TwitchRobo2 extends PircBot {
    private final Credentials cred = new Credentials();
    
    private Map<String, Integer> input = new HashMap<String, Integer>();
    
    /**
     * 
     */
    public TwitchRobo2() {
        this.setName(cred.getUsername2());
        input.put("start", KeyEvent.VK_D);
        input.put("up", KeyEvent.VK_B);
        input.put("down", KeyEvent.VK_V);
        input.put("left", KeyEvent.VK_N);
        input.put("right", KeyEvent.VK_M);
        input.put("a", KeyEvent.VK_K);
        input.put("b", KeyEvent.VK_1);
        input.put("l", KeyEvent.VK_F);
        input.put("r", KeyEvent.VK_U);
        input.put("z", KeyEvent.VK_Y);
        input.put("cup", KeyEvent.VK_O);
        input.put("cdown", KeyEvent.VK_P);
        input.put("cleft", KeyEvent.VK_J);
        input.put("cright", KeyEvent.VK_I);
       
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
        try{
                this.connect("irc.twitch.tv", 6667, cred.getToken2());
                this.joinChannel(cred.getChannel2());
                    
            }catch (IOException ex) {
                Logger.getLogger(TwitchRobo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IrcException ex) {
                Logger.getLogger(TwitchRobo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

