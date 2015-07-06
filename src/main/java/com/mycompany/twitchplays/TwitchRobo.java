/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.jibble.pircbot.PircBot;

/**
 *
 * @author john
 */
public class TwitchRobo extends PircBot {
    private final Credentials cred = new Credentials();
    
    
    public TwitchRobo() {
        this.setName(cred.getUsername());
        
        
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message){
        
            if(message.equalsIgnoreCase("enter")){
                    try{
                        Robot robo = new Robot();
                        robo.delay(1500);
                        robo.keyPress(KeyEvent.VK_Q);
                        robo.delay(100);
                        robo.keyRelease(KeyEvent.VK_Q);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                
                 if(message.equalsIgnoreCase("up")){
                    try{
                        Robot robo = new Robot();
                        robo.delay(1500);
                        robo.keyPress(KeyEvent.VK_U);
                        robo.delay(100);
                        robo.keyRelease(KeyEvent.VK_U);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                 
                  if(message.equalsIgnoreCase("down")){
                    try{
                        Robot robo = new Robot();
                        robo.delay(1500);
                        robo.keyPress(KeyEvent.VK_D);
                        robo.delay(100);
                        robo.keyRelease(KeyEvent.VK_D);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                  
                   if(message.equalsIgnoreCase("a")){
                    try{
                        Robot robo = new Robot();
                        robo.delay(1500);
                        robo.keyPress(KeyEvent.VK_A);
                        robo.delay(100);
                        robo.keyRelease(KeyEvent.VK_A);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                  
                  if(message.equalsIgnoreCase("b")){
                    try{
                        Robot robo = new Robot();
                        robo.delay(1500);
                        robo.keyPress(KeyEvent.VK_B);
                        robo.delay(100);
                        robo.keyRelease(KeyEvent.VK_B);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                  
                   if(message.equalsIgnoreCase("left")){
                    try{
                        Robot robo = new Robot();
                        robo.delay(1500);
                        robo.keyPress(KeyEvent.VK_L);
                        robo.delay(100);
                        robo.keyRelease(KeyEvent.VK_L);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                   
                    if(message.equalsIgnoreCase("right")){
                    try{
                        Robot robo = new Robot();
                        robo.delay(1500);
                        robo.keyPress(KeyEvent.VK_R);
                        robo.delay(100);
                        robo.keyRelease(KeyEvent.VK_R);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
	}
    
}
