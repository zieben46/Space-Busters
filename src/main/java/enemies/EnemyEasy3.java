package main.java.enemies;

import main.java.EntityBehaviors.SpreadBulletBehavior;
import main.java.classes.EnemyEntity;
import main.java.game.ImageLoader;

public class EnemyEasy3 extends Enemy implements EnemyEntity {
	
	public EnemyEasy3() {
		super();
		Vx=random.nextInt(6)-3;
		Vy=random.nextInt(1)+4;
		health=10;
		bulletBehavior=new SpreadBulletBehavior();
		bulletSpeed=6;
		bulletCoolDownTime=1*1000;
	}
	
	@Override
	void getImage() {
		shipImage = ImageLoader.EnemyEasy2;  //??
	}
}
