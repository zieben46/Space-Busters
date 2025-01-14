package game.enemy;

import java.util.Random;

import game.assets.ImageLoader;
import game.bulletbehaviors.SingleBeamBehavior;

public class EnemyBeamEasy extends Enemy {
	int health=30;
	Random random=new Random();
	
	public EnemyBeamEasy() {
		super();
		y=-random.nextInt(200)-400;
		y=-400;
		Vx=0;
		Vy=random.nextInt(2)+5;
		health=20;
		bulletBehavior=new SingleBeamBehavior();
		bulletCoolDownTime=.005*1000;
		bulletSpeed=10;
	}

	@Override
	void getImage() {
		shipImage = ImageLoader.enemyBeamEasy;
	}
	
	@Override
	protected boolean wantsTo() {
		return true;
	}
}
