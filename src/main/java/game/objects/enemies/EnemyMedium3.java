package game.objects.enemies;

import java.awt.image.BufferedImage;

import game.objects.projectiles.behaviors.SpreadBullet;
import game.utils.ImageLoader;

public class EnemyMedium3 extends BaseEnemy {
	private long movedTime;
	private double moveCoolTime;

	public EnemyMedium3() {
		super();
		Vx=random.nextInt(6)-3;
		Vy=random.nextInt(4)+4;
		health=10;
		bulletBehavior=new SpreadBullet();
		bulletSpeed=2;
		bulletCoolDownTime=.5*1000;
		
		moveCoolTime=3*1000;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.enemyMedium3; ////???
	}

	@Override
	protected void randomMove() {
		long currentTime=System.currentTimeMillis();
		if (currentTime-movedTime>=moveCoolTime&&wantsTo()) {
			Vx=random.nextInt(8)-4;
			Vy=random.nextInt(4)+4;
			movedTime=currentTime;
		}
	}
}

