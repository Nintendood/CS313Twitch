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
    
    
    
    
    public TwitchRobo() {
        this.setName(cred.getUsername());
        input.put("enter", KeyEvent.VK_O);
        input.put("up", KeyEvent.VK_U);
        input.put("down", KeyEvent.VK_D);
        input.put("a", KeyEvent.VK_A);
        input.put("b", KeyEvent.VK_B);
        input.put("left", KeyEvent.VK_L);
        input.put("right", KeyEvent.VK_R);
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message){
        
        try{
            Robot robo = new Robot();
            robo.delay(1500);
            robo.keyPress(input.get(message));
            robo.delay(100);
            robo.keyRelease(input.get(message));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
