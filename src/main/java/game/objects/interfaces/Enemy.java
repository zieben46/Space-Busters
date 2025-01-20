package game.objects.interfaces;

import java.util.ArrayList;

public interface Enemy extends Drawable {
	void takeDamage(int damage);
	boolean isDead();
	public enum EnemyType {
		Easy1,
		Easy2,
		Easy3,
		EasySuicide,
		Medium1,
		Medium3,
		MediumSuicide,
		AIEasy,
		AIEasySlave,
		CarrierEasy,
		AIMediumSlave,
		BeamEasy
	}

	ArrayList<Projectile> randomBullet();
	void setNewPosition();
	void setX(int x);
}