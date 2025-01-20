package game.gameobjects.interfaces;

public interface UpgradeEntity extends Drawable {
	
	enum UpgradeType {
		gunType,
		gunRate,
		movement,
		healthPack
	}
	abstract UpgradeType upgradeType();
}
