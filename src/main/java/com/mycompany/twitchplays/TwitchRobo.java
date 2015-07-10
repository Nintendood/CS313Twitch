/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.jibble.pircbot.PircBot;

/**
 *
 * @author john
 */
public class TwitchRobo extends PircBot {
    private final Credentials cred = new Credentials();
    
    private Map<String, Integer> input = new HashMap<String, Integer>();
    long thirtyMin = 1800000;
    
    /**
     * 
     */
    public TwitchRobo() {
        this.setName(cred.getUsername());
        input.put("enter", KeyEvent.VK_ENTER);
        input.put("up", KeyEvent.VK_NUMPAD8);
        input.put("down", KeyEvent.VK_NUMPAD2);
        input.put("a", KeyEvent.VK_X);
        input.put("b", KeyEvent.VK_C);
        input.put("left", KeyEvent.VK_NUMPAD4);
        input.put("right", KeyEvent.VK_NUMPAD6);
        input.put("lt", KeyEvent.VK_X);
        input.put("rt", KeyEvent.VK_C);
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
        while (!isConnected()) {
            try {
                reconnect();
            }
            catch (Exception e) {
                // Couldn't reconnect!
                // Pause for a short while...?
            }
        }
    }
    
}
