package game.entities.interfaces;

public interface UpgradeEntity extends Entity {
	
	enum UpgradeType {
		gunType,
		gunRate,
		movement,
		healthPack
	}
	abstract UpgradeType upgradeType();
}
