package game.objects.enemies;

import java.awt.image.BufferedImage;

import game.core.Controller.StatsTracker;
import game.core.Game;
import game.objects.projectiles.behaviors.Off;
import game.utils.ImageLoader;

public class EnemySuicide extends BaseEnemy {
	private int velocity;

	public EnemySuicide(int velocity, int health) {
		super();
		Vx = 0;
		Vy = 0;
		this.health = health;
		frontFireBehavior = new Off();
		bulletSpeed = 0;
		bulletCoolDownTime = 10000*1000;
		
		initialPosition();
		this.velocity = velocity;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.enemySuicide;
	}

	@Override
	public void update() {
		double deltaX = x-StatsTracker.playerX;
		double deltaY = y-StatsTracker.playerY;
		double distance = Math.sqrt(deltaX*deltaX+deltaY*deltaY);
		x-= (int) ((deltaX/distance)*velocity);
		y-= (int) ((deltaY/distance)*velocity);
	}

	private void initialPosition() {
		int bufferedX = random.nextInt(20);
		int bufferedY = random.nextInt(20);
		int quadrant = random.nextInt(8)+1;

		switch (quadrant) {
		case 1:
			x = 0-bufferedX;
			y = 0-bufferedY;
			break;
		case 2:
			x = 0-bufferedX;
			y = random.nextInt(Game.HEIGHT);
			break;
		case 3:
			x = 0-bufferedX;
			y = Game.HEIGHT+bufferedY;
			break;
		case 4:
			x = random.nextInt(Game.WIDTH);
			y = 0-bufferedY;
			break;
		case 5:
			x = random.nextInt(Game.WIDTH);
			y = Game.WIDTH+bufferedY;
			break;
		case 6:
			x = Game.WIDTH+bufferedX;
			y = Game.WIDTH-bufferedY;
			break;
		case 7:
			x = Game.WIDTH+bufferedX;
			y = random.nextInt(Game.HEIGHT);
			break;
		case 8:
			x = Game.WIDTH+bufferedX;
			y = Game.HEIGHT+bufferedY;
			break;
		}
	}
}
