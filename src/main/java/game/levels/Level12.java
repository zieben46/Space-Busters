package game.levels;

import java.util.LinkedList;

import game.objects.Player;
import game.objects.enemies.EnemyAIEasySlave;
import game.objects.enemies.EnemyCarrierEasy;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Enemy.EnemyType;

public class Level12 extends LevelBase {
	private int totalSlaves;
	private int slavesPerCarr = 20;

	public Level12(LinkedList<Enemy> enemyEntities, Player player) {
		super(enemyEntities, player);
		totalEnemies = 3;
		totalSlaves = slavesPerCarr*totalEnemies;
		enemyRate = 12;
		healthPackSpawn = 5;
	}

	@Override
	public void initialize() {
		for (int i=1; i<=totalEnemies; i++) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.CarrierEasy));
		}

		for (int i=1; i <=totalSlaves; i++) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIEasySlave));
		}
	}

	@Override
	public void addEnemy() {
		int currSlaveCount = 0;
		int currCarrierCount = 0;
		for (Enemy enemyEntity: enemyEntities) {
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



