package main.java.level;

import java.util.LinkedList;

import main.java.entity.EnemyEntity;
import main.java.entity.EnemyEntity.EnemyType;
import main.java.game.MyShip;

public class Level6 extends Level {

	public Level6(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=30;
		enemyRate=4;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium3));
			enemiesAdded++;
		}
	}
}
