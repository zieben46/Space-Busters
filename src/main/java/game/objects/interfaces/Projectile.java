package game.objects.interfaces;

public interface Projectile extends Drawable {
	
	enum Team {
		FRIENDLY,
		ENEMY
	}
	
	int getDamage();
	Team team();
}
