package game.objects.enemies;

import java.awt.image.BufferedImage;
import java.util.Random;

import game.objects.projectiles.behaviors.ConstantBeam;
import game.utils.ImageLoader;

public class EnemyBeamEasy extends BaseEnemy {
	int health=30;
	Random random=new Random();
	
	public EnemyBeamEasy() {
		super();
		y=-random.nextInt(200)-400;
		y=-400;
		Vx=0;
		Vy=random.nextInt(2)+5;
		health=20;
		bulletBehavior=new ConstantBeam();
		bulletCoolDownTime=.005*1000;
		bulletSpeed=10;
	}

	@Override
	public BufferedImage getImage() {
		return ImageLoader.enemyBeamEasy;
	}
	
	@Override
	protected boolean wantsTo() {
		return true;
	}
}
