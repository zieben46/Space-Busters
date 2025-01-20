package game.objects.enemies;

import java.awt.image.BufferedImage;

import game.objects.projectiles.behaviors.Off;
import game.utils.ImageLoader;

public class EnemyMedium1 extends BaseEnemy {
	int health=30;
	
	public EnemyMedium1() {
		super();
		Vx=0;
		Vy=random.nextInt(5)+14;
		health=10;
		frontFireBehavior=new Off();
		bulletSpeed=0;
		bulletCoolDownTime=10000*1000;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.enemyMedium1; ////???
	}
}
