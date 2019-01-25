package main.java.level;

import java.util.LinkedList;

import main.java.classes.EnemyEntity;
import main.java.classes.EnemyEntity.EnemyType;
import main.java.game.MyShip;

public class Level15 extends Level {

	public Level15(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=150;
		enemyRate=6;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium3));
		}
		enemiesAdded++;
	}
}
