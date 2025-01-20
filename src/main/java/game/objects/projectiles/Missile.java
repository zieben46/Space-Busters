package game.objects.projectiles;

import game.utils.ImageLoader;

public class Missile extends Bullet {

	public Missile(int x, int y, int Vx, int Vy, Team team) {
		super(x-13, y+20, Vx, Vy, team);
		getImage();
	}

	public void getImage() {
		if (Vx<0) {
			projectileImage = ImageLoader.missileLeft;
		} else if (Vx>0) {
			projectileImage = ImageLoader.missileRight;
		}
	}

	public int getDamage() {
		return 100;
	}
}