package game.objects.enemies;

import java.util.ArrayList;
import java.util.Random;

import java.awt.image.BufferedImage;

import game.core.Controller.StatsTracker;
import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.behaviors.DoubleBullets;
import game.utils.ImageLoader;

public class EnemyAIEasy extends BaseEnemy {
	private Random random = new Random();
	protected boolean canRandomMove = true;
	protected double movedTime;
	protected double moveCoolDownTime = 1*1000;
	private int rapidFireCoolDownTime = 3*1000;
	private int rapidFireCount;
	private double rapidFiredTime;

	public EnemyAIEasy() {
		super();
		Vx = random.nextInt(10)-5;
		Vy = 5;
		health = 40;
		frontFireBehavior = new DoubleBullets();
		bulletSpeed = 8;
		bulletCoolDownTime = 0.01*1000;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.enemyAIEasy;
	}

	@Override
	public void randomMove() {
		double deltaY = StatsTracker.playerY-y;
		if (deltaY<200) {
			Vy=-4;
		} else if (deltaY>400){
			Vy = 3;
		}

		double currentTime = System.currentTimeMillis();
		if ((currentTime-movedTime)>= moveCoolDownTime) {
			int deltaX = StatsTracker.playerX-x;
			if (deltaX>0) {
				Vx = random.nextInt(5)+5;
			} else {
				Vx = random.nextInt(5)-5;
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
