import java.util.HashMap;
import java.util.Map;

import processing.core.*;
import processing.core.PApplet;
import processing.core.PVector;

public class Boid {

	private PVector coords, velocity, acceleration;
	private PApplet p;
	private float direction, size;
	private Map<String, Integer> colors = new HashMap<String, Integer>();
	
	public Boid(PApplet canvas) {
		
		this.p = canvas;
		this.coords = PVector.random2D();
		this.velocity = new PVector();
		this.acceleration = new PVector();
		this.direction = 0;
		this.size = 25;
    	colors.put("background", p.color(31, 54, 61)); // dark blue
    	colors.put("outline", p.color(36, 33, 36)); // raisin black
    	colors.put("body", p.color(156, 175, 183)); //light grey

		
		
	}
	
	public PVector coords() {
		return this.coords;
	}
	
	public PVector velocity() {
		return this.velocity;
	}
	
	public PVector acceleration() {
		return this.acceleration;
	}
	
	public float direciton() {
		return this.direction;
	}
	
	public void setCoords(PVector c) {
		this.coords.set(c);
	}
	
	public void setVelocity(PVector v) {
		this.velocity.set(v);
	}
	
	public void setAcceleration(PVector a) {
		this.acceleration.set(a);
	}
	
	public void setDireciton(float d) {
		this.direction = d;
	}
	
	public void show() {
		
		this.p.strokeWeight(2);
		this.p.stroke(this.colors.get("outline"));
		this.p.fill(this.colors.get("body"));
		
		this.p.circle(this.coords.x, this.coords.y, this.size);
		
		
		
	}
	
	

	
	
	@Override
	public String toString() {
		String output = String.format("x: %f, y: %f, dx: %f, dy: %f, d2x: %f, d2y: %f", this.coords.x, this.coords.y, this.velocity.x, this.velocity.y, this.acceleration.x, this.acceleration.y);
		
		return output;
		
	}
	
	
}
