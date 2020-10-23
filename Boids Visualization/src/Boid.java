import processing.core.PVector;

public class Boid {

	PVector coords, velocity, acceleration;
	float direction;
	
	public Boid(PVector coordinates) {
		
		this.coords = coordinates;
		this.velocity.set(0, 0);
		this.acceleration.set(0, 0);
		float direction = 0;
		
	}
	
}
