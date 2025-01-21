package game.objects.enemies;

import java.awt.image.BufferedImage;
import java.util.Random;

import game.objects.projectiles.behaviors.SingleBullet;
import game.utils.ImageLoader;

public class EnemyEasy1 extends BaseEnemy {
	int health = 30;
	Random random = new Random();
	
	public EnemyEasy1() {
		super();
		Vx = 0;
		Vy = random.nextInt(3)+2;
		health = 10;
		frontFireBehavior = new SingleBullet();
		bulletCoolDownTime = 1*1000;
		bulletSpeed = 10;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.EnemyEasy1;
	}

}
