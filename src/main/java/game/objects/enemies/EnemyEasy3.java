package game.objects.enemies;

import java.awt.image.BufferedImage;

import game.objects.projectiles.behaviors.QuadBullet;
import game.utils.ImageLoader;

public class EnemyEasy3 extends BaseEnemy {
	
	public EnemyEasy3() {
		super();
		Vx=random.nextInt(6)-3;
		Vy=random.nextInt(1)+4;
		health=10;
		frontFireBehavior=new QuadBullet();
		bulletSpeed=6;
		bulletCoolDownTime=1*1000;
	}
	
	@Override
	public BufferedImage getImage() {
		return ImageLoader.EnemyEasy2; ////???
	}
}
