package game.gameobjects.interfaces;

public interface ProjectileEntity extends Drawable {
	
	enum Team {
		FRIENDLY,
		ENEMY
	}
	
	abstract int getDamage();
	abstract Team team();
}
