package main.java.enemies;

import main.java.EntityBehaviors.SpreadBulletBehavior;
import main.java.classes.EnemyEntity;
import main.java.game.ImageLoader;

public class EnemyMedium3 extends Enemy implements EnemyEntity {
	private long movedTime;
	private double moveCoolTime;

	public EnemyMedium3() {
		super();
		Vx=random.nextInt(6)-3;
		Vy=random.nextInt(4)+4;
		health=10;
		bulletBehavior=new SpreadBulletBehavior();
		bulletSpeed=2;
		bulletCoolDownTime=.5*1000;
		
		moveCoolTime=3*1000;
	}

	@Override
	void getImage() {
		shipImage = ImageLoader.enemyMedium3;
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

