package game.objects.enemies;

import java.awt.image.BufferedImage;

import game.objects.projectiles.behaviors.SpreadBullet;
import game.utils.ImageLoader;

public class EnemyEasy3 extends BaseEnemy {
	
	public EnemyEasy3() {
		super();
		Vx=random.nextInt(6)-3;
		Vy=random.nextInt(1)+4;
		health=10;
		bulletBehavior=new SpreadBullet();
		bulletSpeed=6;
		bulletCoolDownTime=1*1000;
	}
	
	@Override
	public BufferedImage getImage() {
		return ImageLoader.EnemyEasy2; ////???
	}
}
