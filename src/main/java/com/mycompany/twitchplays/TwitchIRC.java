/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;
import sun.rmi.runtime.Log;

/**
 *
 * @author Adam Harris
 */
public class TwitchIRC extends PircBot{
    private final String token;
    private final String nickname;
    private final String channel;
    private final int port;
    private BufferedReader br;
    private Pattern message;
    
    public TwitchIRC(String nickname, String token, int port, String channel) throws IOException {
        
        this.nickname = nickname;
        this.token = token;
        this.port = port;
        this.channel = channel;
        try {
            this.connect(nickname, port, token);
            System.out.println("TwitchIRC is being called");
            this.joinChannel("#" + channel);
            Logger.getLogger(nickname + " " + token + " " + " " + channel).log(Level.INFO, null);
        } catch (IrcException ex) {
            Logger.getLogger(TwitchIRC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connectToChannel(String channel) throws IOException{
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        writer.write("PASS oauth:" + token + "/r/n");
        writer.write("NICK " + nickname + "/r/n");
        writer.write("JOIN " + channel + "/r/n");
        writer.flush();
        System.out.println("Connected");        
    }
    
    public String readLine() throws IOException{
      System.out.println("readLine is being called");
        return br.readLine();
        
    }
    
    public String readMessage() throws IOException {
        String line = readLine();
        System.out.println("readMessage is being called");

        if (line == null)
        {
            return null;
        }
        Matcher matches = message.matcher(line);
        if(!matches.matches())
        {
            return null;
        }
        return matches.group(1);
    }
    //oauth:q4v9jcr47pe39s5jubfajyzj0vbhjb
}
