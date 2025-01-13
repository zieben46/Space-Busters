package game.projectiles;

import game.assets.ImageLoader;

public class Beam extends Bullet {

	public Beam(int x, int y, int Vx, int Vy, Team team) {
		super(x, y, Vx, Vy, team);
	}

	@Override
	protected void getImage() {
		projectileImage = ImageLoader.beamDown;
	}

	public void update() {
		//do nothing
	}
}