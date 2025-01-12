package main.java.enemies;

import main.java.EntityBehaviors.DuoBulletBehavior;
import main.java.game.ImageLoader;

public class EnemyEasy2 extends Enemy {
	public EnemyEasy2() {
		super();
		Vx=random.nextInt(5)-3;
		Vy=random.nextInt(1)+3;
		health=10;
		bulletBehavior=new DuoBulletBehavior();
		bulletSpeed=5;
		bulletCoolDownTime=0.9*1000;
	}
	
	@Override
	void getImage() {
		shipImage = ImageLoader.EnemyEasy2;
	}
}
