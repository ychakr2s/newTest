$(function () {
    'use strict';
    // HEADER: Adjust Slider Height
    var windowHeigh = $(window).height();
    // var upperH = $('.upper-bar').innerHeight();
    var navH = $('.navbar').innerHeight();
    $('.slider, .carousel-item').height(windowHeigh - navH);
});
// // ++++++++++++++++++++++++++ End Change the Color if the link is clicked ++++++++++++++++++++++++++++++++++++++++++//
