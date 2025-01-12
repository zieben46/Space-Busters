package main.java.level;

import java.util.LinkedList;

import main.java.entity.EnemyEntity;
import main.java.entity.EnemyEntity.EnemyType;
import main.java.game.MyShip;

public class Level9 extends Level {

	public Level9(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=150;
		enemyRate=7;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIEasy));
		}
		enemiesAdded++;
	}
}
