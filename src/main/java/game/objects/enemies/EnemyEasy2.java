package game.objects.enemies;

import java.awt.image.BufferedImage;

import game.objects.projectiles.behaviors.DoubleBullets;
import game.utils.ImageLoader;

public class EnemyEasy2 extends BaseEnemy {
	public EnemyEasy2() {
		super();
		Vx = random.nextInt(5)-3;
		Vy = random.nextInt(1)+3;
		health = 10;
		frontFireBehavior = new DoubleBullets();
		bulletSpeed = 5;
		bulletCoolDownTime = 0.9*1000;
	}
	
	@Override
	public BufferedImage getImage() {
		return ImageLoader.EnemyEasy2;
	}
}
