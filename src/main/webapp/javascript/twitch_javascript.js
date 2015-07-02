/*
 * twitch_javascript.js
 */

$(document).ready(function() {
    var chat = $("#chat");
    chat.on("load", function() {
        chat.contents().click(function() {
            alert("HERE!");
        });
    });
});

// Grab the text when the user pushes the button!
$("#chat").load(function() {
    var chat = $("#chat").contents();

     // Now check for a click event!
    chat.find("button").click(function() {
        alert("BUTTON clicked!");
    });
});