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
        <title>CS313 Plays Games</title>
    </head>
    <body>
        <h1>CS313 Plays Games!</h1>
        
        <iframe id="player" type="text/html" width="800" height="600"
        src="http://www.twitch.tv/nintendood_prime/embed"
        frameborder="0">
            
        </iframe>
    </body>
</html>
