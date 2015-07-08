<%-- 
    Document   : index
    Created on : Jun 23, 2015, 11:33:01 AM
    Author     : Adam Harris, Sam Hibbard, John Decker
--%>

<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="javascript/twitch_javascript.js"></script>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <title>CS313 Plays Games</title>
    </head>
    <body>
        <%
            // Grab the servlet
            ServletContext app = getServletConfig().getServletContext();
            
            // Grab which player it needs to be!
            String isPlayerOne = (String) app.getAttribute("player");
            
            // Now change the attribute!
            if(isPlayerOne == null) {
                isPlayerOne = "true";
                app.setAttribute("player", "false");
            }
            else if (isPlayerOne.equals("true")) {
                app.setAttribute("player", "false");
            } else {
                app.setAttribute("player", "true");
            }
        %>
        <div class="container">
            <div class="jumbotron">
                <h1>CS313 Plays Games</h1>                
            </div>
            <div class="row">
                <div class="col-sm-8">                
                    <iframe src="http://www.twitch.tv/nintendood_prime/embed" frameborder="0" scrolling="no" height="560" width="780"></iframe>            
                </div>
                <div class="col-sm-4">           
                    <div class=<%= (isPlayerOne.equals("true")) ? "" : "none"%>>
                        <div class="purple panel-player">
                            <p class="center">Player One</p>                            
                        </div>
                        <iframe id="chat" src="http://www.twitch.tv/nintendood_prime/chat?popout=" frameborder="0" scrolling="no" height="500" width="360"></iframe>                                                    
                    </div>
                    <div class=<%= (isPlayerOne.equals("true")) ? "none" : ""%>>
                        <div class="purple panel-player">
                            <p class="center">Player Two</p>                            
                        </div>
                        <iframe id="chat" src="http://www.twitch.tv/twitchplayssupemarrpg/chat?popout=" frameborder="0" scrolling="no" height="500" width="360"></iframe>                                                    
                    </div>
                </div>
            </div>
        </div>
        <br />
        <div class="container">
            <ul class="nav nav-pills">
              <li id="about" class="active">
                  <a href="#about" data-toggle="tab">About</a>
              </li>
              <li id="howToPlay">
                  <a href="#howToPlay" data-toggle="tab">How to Play</a>
              </li>
            </ul>
            <br />
            <div id="about" class="panel panel-primary">
                <div class="panel panel-heading">About</div>
                <div class="panel panel-body">
                    CS313 Twitch Plays is a website that allows the user to play Super Mario RPG. This is currently in development. 
                </div>
            </div>
            <div id="howToPlay" class="panel panel-primary none">
                <div class="panel panel-heading">How to Play</div>
                <div class="panel panel-body">
                    Currently in development.
                </div>
            </div>
        </div>
        <br/>
    </body>
</html>
