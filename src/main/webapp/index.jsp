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
                <h1>We Play Games</h1>                
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
              <li id="demoAccount">
                  <a href="#demoAccount" data-toggle="tab">Don't Have a Twitch Account?</a>
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
                    <h1>N64 Controls</h1>
                    <h3>Input Commands</h3>
                    <table class='table table-striped'>
                        <thead>
                            <tr>
                                <th>Input</th>
                                <th>Button Pressed</th>
                            </tr>                          
                        </thead>
                        <tbody>
                            <tr>
                                <td>a</td>
                                <td>A Button</td>
                            </tr>
                            <tr>
                                <td>b</td>
                                <td>B Button</td>
                            </tr>
                            <tr>
                                <td>start</td>
                                <td>Start Button</td>
                            </tr>
                            <tr>
                                <td>rt</td>
                                <td>Right Trigger</td>
                            </tr>
                            <tr>
                                <td>lt</td>
                                <td>Left Trigger</td>
                            </tr>                             
                        </tbody>
                    </table>                 
                    <br />
                    <h3>Analog Stick Commands</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Input</th>
                                <th>Analog Controls</th>
                            </tr>                          
                        </thead>
                        <tbody>
                            <tr>
                                <td>up</td>
                                <td>Directional Up</td>
                            </tr>
                            <tr>
                                <td>down</td>
                                <td>Directional Down</td>
                            </tr>
                            <tr>
                                <td>left</td>
                                <td>Directional Left</td>
                            </tr>
                            <tr>
                                <td>Right</td>
                                <td>Directional Right</td>
                            </tr>
                        </tbody>
                    </table>
                    <br />
                    <h3>C-Button Commands</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Input</th>
                                <th>C Buttons Pressed</th>
                            </tr>                          
                        </thead>
                        <tbody>
                            <tr>
                                <td>cu</td>
                                <td>Up Button</td>
                            </tr>
                            <tr>
                                <td>cd</td>
                                <td>Down Button</td>
                            </tr>
                            <tr>
                                <td>cl</td>
                                <td>Left Button</td>
                            </tr>
                            <tr>
                                <td>cr</td>
                                <td>Right Button</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="demoAccount" class="panel panel-primary none">
                <div class="panel panel-heading">Don't Have a Twitch Account?</div>
                <div class="panel panel-body">
                    <h2>Here are some demo accounts:</h2>
                    <br />
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Username:</th>
                                <th>Password:</th>
                            </tr>                            
                        </thead>
                        <tbody>
                            <tr>
                                <td>WePlatGames01</td>
                                <td>playgames01</td>
                            </tr>
                            <tr>
                                <td>WePlayGames02</td>
                                <td>playgames02</td>
                            </tr>
                        </tbody>
                    </table>
                    <br />
                    <h4>Or you can sign up for your own twitch account <a class="blue" href="http://www.twitch.tv/">here</a></h4>                  
                </div>
            </div>
        </div>
        <br/>
    </body>
</html>
