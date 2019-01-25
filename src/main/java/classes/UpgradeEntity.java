package main.java.classes;

public interface UpgradeEntity extends Entity {
	
	enum UpgradeType {
		gunType,
		gunRate,
		movement,
		healthPack
	}
	abstract UpgradeType upgradeType();
}
