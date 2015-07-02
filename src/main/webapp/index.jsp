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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <title>CS313 Plays Games</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>CS313 Plays Games</h1>                
            </div>
            <div class="row">
                <div class="col-sm-8">                
                    <iframe src="http://www.twitch.tv/nintendood_prime/embed" frameborder="0" scrolling="no" height="560" width="780"></iframe>            
                </div>
                <div class="col-sm-4">
                    <iframe id="chat" src="http://www.twitch.tv/nintendood_prime/chat?popout=" frameborder="0" scrolling="no" height="560" width="360"></iframe>                            
                </div>
            </div>
        </div>
        <br />
        <div class="container">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">How to Play</a></li>
            </ul>
        </div>
        <br/>
    </body>
</html>
