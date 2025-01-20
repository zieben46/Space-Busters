package game.enemy;

import game.projectiles.projectilebehaviors.SpreadBulletBehavior;
import game.utils.ImageLoader;

public class EnemyEasy3 extends Enemy {
	
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
