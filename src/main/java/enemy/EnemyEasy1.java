package main.java.enemy;

import java.util.Random;

import main.java.bulletbehavior.SingleBulletBehavior;
import main.java.game.ImageLoader;

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
