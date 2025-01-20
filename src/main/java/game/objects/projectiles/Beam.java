package game.objects.projectiles;

import game.utils.ImageLoader;

public class Beam extends Bullet {

	public Beam(int x, int y, int Vx, int Vy, Team team) {
		super(x, y, Vx, Vy, team);
	}

	@Override
	public void getImage() {
		projectileImage = ImageLoader.beamDown;
	}

	@Override
	public void update() {
		//do nothing
	}
}