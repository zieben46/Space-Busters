package game.gameobjects.enemy;

import game.gameobjects.projectiles.projectilebehaviors.NullBulletBehavior;
import game.utils.ImageLoader;

public class EnemyMedium1 extends BaseEnemy {
	int health=30;
	
	public EnemyMedium1() {
		super();
		Vx=0;
		Vy=random.nextInt(5)+14;
		health=10;
		bulletBehavior=new NullBulletBehavior();
		bulletSpeed=0;
		bulletCoolDownTime=10000*1000;
	}

	@Override
	void getImage() {
		shipImage = ImageLoader.enemyMedium1;
	}
}
