package game.enemy;

import java.util.Random;

import game.assets.ImageLoader;
import game.bulletbehaviors.SingleBulletBehavior;

public class EnemyEasy1 extends Enemy {
	int health=30;
	Random random=new Random();
	
	public EnemyEasy1() {
		super();
		Vx=0;
		Vy=random.nextInt(3)+2;
		health=10;
		bulletBehavior=new SingleBulletBehavior();
		bulletCoolDownTime=1*1000;
		bulletSpeed=10;
	}

	@Override
	void getImage() {
		shipImage = ImageLoader.EnemyEasy1;
	}

}
