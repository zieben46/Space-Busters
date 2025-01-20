package game.objects.enemies;

import java.awt.image.BufferedImage;

import game.objects.projectiles.behaviors.NoBullets;
import game.utils.ImageLoader;

public class EnemyMedium1 extends BaseEnemy {
	int health=30;
	
	public EnemyMedium1() {
		super();
		Vx=0;
		Vy=random.nextInt(5)+14;
		health=10;
		bulletBehavior=new NoBullets();
		bulletSpeed=0;
		bulletCoolDownTime=10000*1000;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.enemyMedium1; ////???
	}
}
