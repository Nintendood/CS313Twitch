/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitchplays;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adam Harris
 */
public class TypeMain {
    public static void main(String[] args) {
        Map<String, String> commands = new HashMap<String, String>();
        commands.put("start", "x");
        commands.put("a", "a");
        commands.put("b", "b");
        commands.put("left", "l");
        commands.put("right", "r");
        commands.put("up", "u");
        commands.put("down", "d");

        try {
            TwitchIRC irc = new TwitchIRC("nintendood_prime", "q4v9jcr47pe39s5jubfajyzj0vbhjb");
            irc.connectToChannel("#CS313PlaysGames");
            String message;
            while (true) {
                message = irc.readMessage().toLowerCase();
                System.out.println(message);
                if (message != null) {
                    if (commands.containsKey(message)) {
                        execute(args[0], commands.get(message));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void execute(String window, String button) throws IOException {
        String command =
                "xdotool search --desktop 0 " + window + " windowactivate --sync key --clearmodifiers " + button;
        Runtime.getRuntime().exec(command);
    }
}