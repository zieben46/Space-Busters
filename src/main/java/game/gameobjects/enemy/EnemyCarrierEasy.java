package game.gameobjects.enemy;

import java.util.Random;

import game.gameobjects.projectiles.projectilebehaviors.NullBulletBehavior;
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
		bulletBehavior=new NullBulletBehavior();
		bulletSpeed=0;
		bulletCoolDownTime=10000*1000;
	}

	@Override
	public void getImage() {
		shipImage = ImageLoader.enemyCarrierEasy;
	}

	@Override
	public void randomMove() {
		double deltaY=EnemyAI.getPlayerY()-y;
		if (deltaY<500) {
			Vy=-2;
		} else if (deltaY>550){
			Vy=2;
		}

		double currentTime=System.currentTimeMillis();
		if ((currentTime-movedTime)>=moveCoolDownTime) {
			int deltaX=EnemyAI.getPlayerX()-x;
			if (deltaX>0) {
				Vx=random.nextInt(2)+2;
			} else {
				Vx=random.nextInt(2)-2;
			}
			movedTime=currentTime;
		}
	}
}
