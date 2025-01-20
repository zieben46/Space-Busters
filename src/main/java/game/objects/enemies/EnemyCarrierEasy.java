package game.objects.enemies;

import java.awt.image.BufferedImage;
import java.util.Random;

import game.objects.projectiles.behaviors.NoBullets;
import game.utils.ImageLoader;

public class EnemyCarrierEasy extends BaseEnemy {
	private Random random=new Random();
	protected boolean canRandomMove=true;
	protected double movedTime;
	protected double moveCoolDownTime=2*1000;

	public EnemyCarrierEasy() {
		super();
		Vx=random.nextInt(8);
		Vy=2;
		health=350;
		bulletBehavior=new NoBullets();
		bulletSpeed=0;
		bulletCoolDownTime=10000*1000;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.enemyCarrierEasy;
	}

	@Override
	public void randomMove() {
		double deltaY=Radar.getPlayerY()-y;
		if (deltaY<500) {
			Vy=-2;
		} else if (deltaY>550){
			Vy=2;
		}

		double currentTime=System.currentTimeMillis();
		if ((currentTime-movedTime)>=moveCoolDownTime) {
			int deltaX=Radar.getPlayerX()-x;
			if (deltaX>0) {
				Vx=random.nextInt(2)+2;
			} else {
				Vx=random.nextInt(2)-2;
			}
			movedTime=currentTime;
		}
	}
}
