package main.java.level;

import java.util.LinkedList;

import main.java.classes.EnemyEntity;
import main.java.classes.EnemyEntity.EnemyType;
import main.java.enemies.EnemyAIEasySlave;
import main.java.enemies.EnemyCarrierEasy;
import main.java.game.MyShip;

public class Level12 extends Level {
	private int totalSlaves;
	private int slavesPerCarr=20;

	public Level12(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=3;
		totalSlaves=slavesPerCarr*totalEnemies;
		enemyRate=12;
		healthPackSpawn=5;
	}

	@Override
	public void initialize() {
		for (int i=1; i<=totalEnemies; i++) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.CarrierEasy));
		}

		for (int i=1; i<=totalSlaves; i++) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIEasySlave));
		}
	}

	@Override
	public void addEnemy() {
		int currSlaveCount=0;
		int currCarrierCount=0;
		for (EnemyEntity enemyEntity: enemyEntities) {
			if (enemyEntity.getClass().equals(EnemyAIEasySlave.class)) {
				currSlaveCount++;
			} else if (enemyEntity.getClass().equals(EnemyCarrierEasy.class)) {
				currCarrierCount++;
			}
		}

		if (currSlaveCount<slavesPerCarr*currCarrierCount) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIEasySlave));
		}
	}
}



