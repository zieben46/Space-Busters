package game.objects.enemies;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import game.core.Controller.StatsTracker;
import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.behaviors.Off;
import game.utils.ImageLoader;

public class EnemyAIMediumSlave extends EnemyAIEasy {
	private Random random = new Random();
	protected boolean canRandomMove = true;
	protected double movedTime;
	protected double moveCoolDownTime = .2*1000;
	private int rapidFireCoolDownTime = 6*1000;
	private int rapidFireCount;
	private double rapidFiredTime;

	public EnemyAIMediumSlave() {
		super();
		Vx = random.nextInt(10)-5;
		Vy = 8;
		health = 100;
		frontFireBehavior = new Off();
		bulletSpeed = 5;
		bulletCoolDownTime = 10000*1000;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.EnemyAIMediumSlave;
	}

	@Override
	public void randomMove() {
		double currentTime = System.currentTimeMillis();
		if ((currentTime-movedTime)>= moveCoolDownTime) {
			int deltaX = StatsTracker.playerX-x;
			if (deltaX>0) {
				Vx = random.nextInt(10)+10;
			} else {
				Vx = random.nextInt(10)-10;
			}
			movedTime = currentTime;
		}
	}

	@Override
	public ArrayList<Projectile> randomBullet() {
		double currentTime = System.currentTimeMillis();
		if ((currentTime-firedTime)>bulletCoolDownTime&&
				(currentTime-rapidFiredTime>rapidFireCoolDownTime)&&wantsTo()) {
			rapidFireCount++;
			firedTime = currentTime;
			if (rapidFireCount == 3) {
				rapidFiredTime = currentTime;
				rapidFireCount = 0;
			}
			return frontFireBehavior.fire(x+(getWidth()/2-5), y+getHeight(), Vx, Vy+bulletSpeed, Team.ENEMY);
		}
		return null;
	}


}
