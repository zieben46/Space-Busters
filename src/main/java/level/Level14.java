package main.java.level;

import java.util.LinkedList;

import main.java.classes.EnemyEntity;
import main.java.classes.EnemyEntity.EnemyType;
import main.java.enemies.EnemyAIEasySlave;
import main.java.enemies.EnemyCarrierEasy;
import main.java.game.MyShip;

public class Level14 extends Level {
	private int totalSlaves;
	private int slavesPerCarr=3;

	public Level14(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=5;
		totalSlaves=slavesPerCarr*totalEnemies;
		enemyRate=12;
	}
	
	@Override
	public void initialize() {
		for (int i=1; i<=totalEnemies; i++) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.CarrierEasy));
		}
		
		for (int i=1; i<=totalSlaves; i++) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIMediumSlave));
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
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIMediumSlave));
		}
	}
}



