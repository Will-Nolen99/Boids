import processing.core.PVector;

public class Boid {

	PVector coords, velocity, acceleration;
	float direction;
	
	public Boid(PVector coordinates) {
		
		this.coords = coordinates;
		this.velocity.set(0, 0);
		this.acceleration.set(0, 0);
		this.direction = 0;
		
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
	
	
	
	
	
	
	@Override
	public String toString() {
		String output = String.format("x: %f, y: %f, dx: %f, dy: %f, d2x: %f, d2y: %f", this.coords.x, this.coords.y, this.velocity.x, this.velocity.y, this.acceleration.x, this.acceleration.y);
		
		return output;
		
	}
	
	
}
