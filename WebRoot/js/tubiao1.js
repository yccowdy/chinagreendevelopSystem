Bar.defaults = {
                
    //Boolean - If we show the scale above the chart data            
    scaleOverlay : false,
    
    //Boolean - If we want to override with a hard coded scale
    scaleOverride : false,
    
    //** Required if scaleOverride is true **
    //Number - The number of steps in a hard coded scale
    scaleSteps : null,
    //Number - The value jump in the hard coded scale
    scaleStepWidth : null,
    //Number - The scale starting value
    scaleStartValue : null,

    //String - Colour of the scale line    
    scaleLineColor : "rgba(0,0,0,.1)",
    
    //Number - Pixel width of the scale line    
    scaleLineWidth : 1,

    //Boolean - Whether to show labels on the scale    
    scaleShowLabels : false,
    
    //Interpolated JS string - can access value
    scaleLabel : "<%=value%>",
    
    //String - Scale label font declaration for the scale label
    scaleFontFamily : "'Arial'",
    
    //Number - Scale label font size in pixels    
    scaleFontSize : 12,
    
    //String - Scale label font weight style    
    scaleFontStyle : "normal",
    
    //String - Scale label font colour    
    scaleFontColor : "#666",    
    
    ///Boolean - Whether grid lines are shown across the chart
    scaleShowGridLines : true,
    
    //String - Colour of the grid lines
    scaleGridLineColor : "rgba(0,0,0,0.5)",
    
    //Number - Width of the grid lines
    scaleGridLineWidth : 1,    

    //Boolean - If there is a stroke on each bar    
    barShowStroke : true,
    
    //Number - Pixel width of the bar stroke    
    barStrokeWidth : 10,
    
    //Number - Spacing between each of the X value sets
    // 柱状块与x值所形成的线（如：x=20这条线）之间的距离
    barValueSpacing : 20,
    
    //Number - Spacing between data sets within X values
    // 在同一x值内的柱状块之间的间距
    barDatasetSpacing : 1,
    
    //Boolean - Whether to animate the chart
    animation : true,

    //Number - Number of animation steps
    animationSteps : 60,
    
    //String - Animation easing effect
    animationEasing : "easeOutQuart",

    //Function - Fires when the animation is complete
    onAnimationComplete : null
    
}