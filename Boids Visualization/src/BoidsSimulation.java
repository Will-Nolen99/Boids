import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PVector;

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
        size(1000, 1000);
        
    }

    // identical use to setup in Processing IDE except for size()
    public void setup(){
    	
    	colors.put("background", color(31, 54, 61)); // dark blue
    	colors.put("outline", color(36, 33, 36)); // raisin black
    	colors.put("body", color(156, 175, 183)); //light grey
    	
    	final int NUMBER_OF_BODIES = 200;

    	
    	
    	for(int i = 0; i < NUMBER_OF_BODIES; i++) {
    		
    		Boid b = new Boid(this);
    		PVector coords = new PVector();
    		
    		coords.x = random(width);
    		coords.y = random(height);

    		
    		PVector vel = PVector.random2D();

    		vel.setMag(random(2, 4));
    		
    		PVector acc = new PVector();
    		acc.x = 0;
    		acc.y = 0;
    		
    		b.setCoords(coords);
    		b.setVelocity(vel);
    		b.setAcceleration(acc);
    		boids.add(b);
    		
    	}
    	
    	
    	
    	
    	
        background(colors.get("background"));
    }

    // identical use to draw in Processing IDE
    public void draw(){
    	
    	background(colors.get("background"));

    	
    	for(Boid b: boids) {
    		
    		b.flock(boids);
    		b.edges();
    		b.update();
    		b.show();
    		
    		
    	}
    		
    	//noLoop();
    }
}