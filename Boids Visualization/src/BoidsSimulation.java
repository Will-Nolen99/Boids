import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;

public class BoidsSimulation extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("BoidsSimulation");
    }

    
    /**
     * Using processing requires global variables as no variables can be passed into draw.
     * 
	 * All the globals will be declared here.
     * 
     */
    
    // This will store the colors used throughout the program.
    // colors will be initialized in setup
    Map<String, Integer> colors = new HashMap<String, Integer>();
    
    ArrayList<Boid> boids = new ArrayList<Boid>();
    
    
    
    
    // method for setting the size of the window
    public void settings(){
        size(500, 500);
        
        
        
    }

    // identical use to setup in Processing IDE except for size()
    public void setup(){
    	
    	colors.put("background", color(31, 54, 61)); // dark blue
    	colors.put("outline", color(36, 33, 36)); // raisin black
    	colors.put("body", color(156, 175, 183)); //light grey
    	
    	
    	
        background(colors.get("background"));
    }

    // identical use to draw in Processing IDE
    public void draw(){
    	
    	strokeWeight(1);
    	stroke(colors.get("outline"));
    	fill(colors.get("body"));
        square(width/2, height/2, 15);
    }
}