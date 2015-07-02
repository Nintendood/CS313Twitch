/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;


import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;

/**
 *
 * @author john
 */
public class TwitchBot extends PircBot {
    Credentials cred = new Credentials();
    private final String token;
    private final String nickname;
    private final String channel;
    private final int port;
    private final String ircName = "irc.twitch.tv";
    private final String infoCon = "Connected";

    public TwitchBot(String token, String nickname, String channel, int port) {
        this.token = token;
        this.nickname = nickname;
        this.channel = channel;
        this.port = port;
    }

    public TwitchBot() {
        this.token = cred.getToken();
        this.nickname = cred.getUsername();
        this.port = 6667;
        this.channel = cred.getChannel();
    }
    
    
   public void connect() throws IrcException {
       //need to set the name so that we can hold the username
       this.setName(nickname);
       
       //set the username
       this.changeNick(nickname);
       
        try {
            //connect to Twitch
            this.connect(ircName, port, token);
            this.joinChannel(channel);
            Logger.getLogger(TwitchBot.class.getName()).log(Level.INFO, infoCon);
            
        } catch (IOException ex) {
            Logger.getLogger(TwitchBot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NickAlreadyInUseException ex) {
            Logger.getLogger(TwitchBot.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
   public void readCommand(Map <String,String> commands){
       String message;
       while (true) {
                message = this.
                System.out.println(message);
                if (message != null) {
                    if (commands.containsKey(message)) {
                        execute(args[0], commands.get(message));
                    }
                }
            }
   }
}
