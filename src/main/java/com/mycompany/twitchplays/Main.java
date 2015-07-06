/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.IrcException;

/**
 *
 * @author john
 */
public class Main {
    
    public static void main(String[] args){
        Credentials cred = new Credentials();
        TwitchRobo trob = new TwitchRobo();
        trob.setVerbose(true);
        try {
            trob.connect("irc.twitch.tv", 6667, cred.getToken());
            trob.joinChannel(cred.getChannel());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IrcException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
