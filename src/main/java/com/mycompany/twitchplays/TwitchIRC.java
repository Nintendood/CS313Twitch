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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Adam Harris
 */
public class TwitchIRC {
    private final String token;
    private final String nickname;
    private final Socket socket;
    private BufferedReader br;
    private Pattern message;
    
    public TwitchIRC(String nickname, String token) throws IOException {
        
        this.nickname = nickname;
        this.token = token;
        this.socket = new Socket();
        socket.connect(new InetSocketAddress("irc.twitch.tv", 6667));
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        message = Pattern.compile(".* PRIVMSG #twitchplays :(.*)");  
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
        return br.readLine();
    }
    
    public String readMessage() throws IOException {
        String line = readLine();
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
