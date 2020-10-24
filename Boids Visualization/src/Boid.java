import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import processing.core.*;
import processing.core.PApplet;
import processing.core.PVector;

public class Boid {

	private PVector coords, velocity, acceleration;
	private PApplet p;
	private float direction = 0; 
	private final int size = 25, vision = 50, maxSpeed = 5;
	private Map<String, Integer> colors = new HashMap<String, Integer>();
	
	private double maxForce = 0.2;
	
	
	
	
	public Boid(PApplet canvas) {
		
		this.p = canvas;
		this.coords = PVector.random2D();
		this.velocity = new PVector();
		this.acceleration = new PVector();
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
	
	public void update() {
		this.coords.add(this.velocity);
		this.velocity.add(this.acceleration);
		
	}
	
	public void edges() {
		
		if(this.coords.x < 0) {
			this.coords.x = p.width;
		}else if(this.coords.x > p.width) {
			this.coords.x = 0;
		}
		
		
		if(this.coords.y < 0) {
			this.coords.y = p.height;
		}else if(this.coords.y > p.height) {
			this.coords.y = 0;
		}
		
		
	}
	
	public void flock(ArrayList<Boid> boids) {
		
		PVector alignment = align(boids);
		PVector cohes = cohesion(boids);
		PVector seperate = seperation(boids);
		
		PVector adjustment = new PVector();
		
		adjustment.add(alignment);
		adjustment.add(cohes);
		adjustment.add(seperate);
		
		this.acceleration = adjustment;

		
		
	}
	
	
	private PVector align(ArrayList<Boid> boids) {
		
		PVector average = new PVector();
		int count = 0;
		
		for(Boid other: boids) {
			if(other != this && this.coords.dist(other.coords()) < this.vision) {
				average.add(other.velocity());
				count++;
				
			}
		}
		
		if(count > 0) {
			average.div(count);
			average.setMag(this.maxSpeed);
			
			average.sub(this.velocity);
			
			average.limit((float) this.maxForce);
		}
		
		return average;
	}
	
	private PVector cohesion(ArrayList<Boid> boids) {
		
		PVector average = new PVector();
		int count = 0;
		
		for(Boid other: boids) {
			if(other != this && this.coords.dist(other.coords()) < this.vision) {
				average.add(other.coords());
				count++;
				
			}
		}
		
		if(count > 0) {
			average.div(count);
			
			average.sub(this.coords);
			average.setMag(this.maxSpeed);
			average.sub(this.velocity);
			average.limit((float) this.maxForce);
		}
		
		return average;
		
	}
	
	
	private PVector seperation(ArrayList<Boid> boids) {
		
		PVector average = new PVector();
		int count = 0;
		
		for(Boid other: boids) {
			float d = this.coords.dist(other.coords());
			if(other != this && d < this.vision) {
				
				PVector difference = PVector.sub(this.coords, other.coords());
				difference.div(d);
				average.add(difference);
				count++;
				
			}
		}
		
		if(count > 0) {
			average.div(count);
			average.setMag(this.maxSpeed);
			average.sub(this.velocity);
			average.limit((float) this.maxForce);
		}
		
		return average;
	}
	
	
	

	
	
	@Override
	public String toString() {
		String output = String.format("x: %f, y: %f, dx: %f, dy: %f, d2x: %f, d2y: %f", this.coords.x, this.coords.y, this.velocity.x, this.velocity.y, this.acceleration.x, this.acceleration.y);
		
		return output;
		
	}
	
	
}
