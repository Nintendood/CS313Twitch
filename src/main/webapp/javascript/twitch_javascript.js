/*
 * twitch_javascript.js
 */

$(document).ready(function() {
    // Grab click events on tabs!
    $("li").click(function() {
        // Which one was clicked on?
        var id = $(this).attr("id");
               
        // Now switch the tab contents
        if (id === 'about') {
            // Grab the div tags
            $("div#about").removeClass("none");
            $("div#howToPlay").addClass("none");
            $("div#demoAccount").addClass("none");
        } else if (id === 'howToPlay') {
            $("div#about").addClass("none");
            $("div#howToPlay").removeClass("none");
            $("div#demoAccount").addClass("none");
        } else {
            $("div#about").addClass("none");
            $("div#howToPlay").addClass("none");
            $("div#demoAccount").removeClass("none");
        }
    });
});